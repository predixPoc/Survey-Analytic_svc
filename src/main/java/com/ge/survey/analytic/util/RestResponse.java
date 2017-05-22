package com.ge.survey.analytic.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestResponse {
	
	private int status;
	
	private Object object;
	
	private String message;
	
	public RestResponse() {
		super();
	}

	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
