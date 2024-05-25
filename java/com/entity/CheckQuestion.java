package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CheckQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkId;
	@OneToOne
	private Student student;
	
	private Question question;

	private Exam exam;
	private String status;
	private String correctAnswer;
	private String studentAnswer;
	private boolean marks;

}
