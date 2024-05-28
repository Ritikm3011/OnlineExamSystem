package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int resultId;
	@ManyToOne
	Exam exam;
	@ManyToOne
	Student student;
	int totalQuestion;
	int attemptedQuestion;
	String startTime;
	String submitTime;
	double totalMarks;
	double positiveMarks;
	double negativeMarks;
	double scoredMarks;
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int resultId, Exam exam, Student student, int totalQuestion, int attemptedQuestion, String startTime,
			String submitTime, double totalMarks, double positiveMarks, double negativeMarks, double scoredMarks) {
		super();
		this.resultId = resultId;
		this.exam = exam;
		this.student = student;
		this.totalQuestion = totalQuestion;
		this.attemptedQuestion = attemptedQuestion;
		this.startTime = startTime;
		this.submitTime = submitTime;
		this.totalMarks = totalMarks;
		this.positiveMarks = positiveMarks;
		this.negativeMarks = negativeMarks;
		this.scoredMarks = scoredMarks;
	}

	public Result(Exam exam, Student student, int totalQuestion, int attemptedQuestion, String startTime,
			String submitTime, double totalMarks, double positiveMarks, double negativeMarks, double scoredMarks) {
		super();
		this.exam = exam;
		this.student = student;
		this.totalQuestion = totalQuestion;
		this.attemptedQuestion = attemptedQuestion;
		this.startTime = startTime;
		this.submitTime = submitTime;
		this.totalMarks = totalMarks;
		this.positiveMarks = positiveMarks;
		this.negativeMarks = negativeMarks;
		this.scoredMarks = scoredMarks;
	}
	
	
	

	

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getAttemptedQuestion() {
		return attemptedQuestion;
	}

	public void setAttemptedQuestion(int attemptedQuestion) {
		this.attemptedQuestion = attemptedQuestion;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getPositiveMarks() {
		return positiveMarks;
	}

	public void setPositiveMarks(double positiveMarks) {
		this.positiveMarks = positiveMarks;
	}

	public double getNegativeMarks() {
		return negativeMarks;
	}

	public void setNegativeMarks(double negativeMarks) {
		this.negativeMarks = negativeMarks;
	}

	public double getScoredMarks() {
		return scoredMarks;
	}

	public void setScoredMarks(double scoredMarks) {
		this.scoredMarks = scoredMarks;
	}

	
	
}
