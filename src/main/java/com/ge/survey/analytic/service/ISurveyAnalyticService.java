package com.ge.survey.analytic.service;

import com.ge.survey.analytic.entity.UserData;
import com.ge.survey.analytic.entity.UserDetails;
import com.ge.survey.analytic.exception.SurveyAnaliticException;


public interface ISurveyAnalyticService {

	UserDetails createUser(UserDetails user) throws SurveyAnaliticException;
	UserData createNewUser(UserData user) throws SurveyAnaliticException;
	UserData findExistingUser(String userName) throws SurveyAnaliticException;
}
