package com.ge.survey.analytic.exception;

public class SurveyAnaliticException extends Exception {
	public SurveyAnaliticException(String message) {
		super(message);
	}

	public SurveyAnaliticException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public SurveyAnaliticException(Throwable throwable) {
		super(throwable);
	}

}
