package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CheckQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkId;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Exam exam;
	private String status;
	private String correctOption;
	private String studentOption;
	private double marks;
	@ManyToOne
	private Result result;

	public CheckQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckQuestion(int checkId, Student student, Question question, Exam exam, String status,
			String correctOption, String studentOption, double marks, Result result) {
		super();
		this.checkId = checkId;
		this.student = student;
		this.question = question;
		this.exam = exam;
		this.status = status;
		this.correctOption = correctOption;
		this.studentOption = studentOption;
		this.marks = marks;
		this.result = result;
	}

	public CheckQuestion(Student student, Question question, Exam exam, String status, String correctOption,
			String studentOption, double marks, Result result) {
		super();
		this.student = student;
		this.question = question;
		this.exam = exam;
		this.status = status;
		this.correctOption = correctOption;
		this.studentOption = studentOption;
		this.marks = marks;
		this.result = result;
	}

	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public String getStudentOption() {
		return studentOption;
	}

	public void setStudentOption(String studentOption) {
		this.studentOption = studentOption;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	
	

}
