package com.ge.survey.analytic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.survey.analytic.entity.UserData;
import com.ge.survey.analytic.entity.UserDetails;
import com.ge.survey.analytic.exception.SurveyAnaliticException;
import com.ge.survey.analytic.repository.AircraftUserRegdRepository;
import com.ge.survey.analytic.repository.SurveyAnalyticRepository;
import com.ge.survey.analytic.service.ISurveyAnalyticService;

@Component
public class SurveyAnalyticServiceImpl implements ISurveyAnalyticService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SurveyAnalyticServiceImpl.class);

	@Autowired
	private SurveyAnalyticRepository surveyRepo;
    
	@Autowired
	private AircraftUserRegdRepository aircraftRepo;

	@Override
	public UserDetails createUser(UserDetails user)
			throws SurveyAnaliticException {
		UserDetails current;
		try {
			current = surveyRepo.save(user);
			LOGGER.debug("User created: " + current.getUserId());
		} catch (Exception e) {
			throw new SurveyAnaliticException("Error while creating User", e);
		}
		return current;
	}
	
	@Override
	public UserData createNewUser(UserData user)
			throws SurveyAnaliticException {
		UserData current;
		try {
			current = aircraftRepo.save(user);
			LOGGER.debug("User created: " + current.getUserId());
		} catch (Exception e) {
			throw new SurveyAnaliticException("Error while creating User", e);
		}
		return current;
	}
	@Override
	public UserData findExistingUser(String userName) throws SurveyAnaliticException{
		UserData existUser;
		try {
			existUser = aircraftRepo.findUser(userName);
		} catch (Exception e) {
			throw new SurveyAnaliticException("Error while creating User", e);
		}
		return existUser;
	}
}
