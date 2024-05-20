package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;
	private String name;
	private String instructions;
	private double positiveMarks;
	private double negativeMarks;
	private String duration;

	private String active;
	private String creationTimestamp;
	@OneToMany(mappedBy = "exam")
	List<Question> question;
	
	
	

	public Exam(String name, String instructions, double positiveMarks, double negativeMarks, String duration,
			String active, String creationTimestamp) {
		super();
		this.name = name;
		this.instructions = instructions;
		this.positiveMarks = positiveMarks;
		this.negativeMarks = negativeMarks;
		this.duration = duration;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
	}

	public Exam(String name, String instructions, double positiveMarks, double negativeMarks, String duration,
			String active, String creationTimestamp, List<Question> question) {
		super();
		this.name = name;
		this.instructions = instructions;
		this.positiveMarks = positiveMarks;
		this.negativeMarks = negativeMarks;
		this.duration = duration;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
		this.question = question;
	}

	public Exam(int examId, String name, String instructions, double positiveMarks, double negativeMarks,
			String duration, String active, String creationTimestamp, List<Question> question) {
		super();
		this.examId = examId;
		this.name = name;
		this.instructions = instructions;
		this.positiveMarks = positiveMarks;
		this.negativeMarks = negativeMarks;
		this.duration = duration;
		this.active = active;
		this.creationTimestamp = creationTimestamp;
		this.question = question;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public double isPositiveMarks() {
		return positiveMarks;
	}

	public void setPositiveMarks(double positiveMarks) {
		this.positiveMarks = positiveMarks;
	}

	public double isNegativeMarks() {
		return negativeMarks;
	}

	public void setNegativeMarks(double negativeMarks) {
		this.negativeMarks = negativeMarks;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public int getExamId() {
		return examId;
	}

}
