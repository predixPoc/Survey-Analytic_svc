package com.ge.survey.analytic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.survey.analytic.dto.RegestrationDTO;
import com.ge.survey.analytic.entity.UserData;
import com.ge.survey.analytic.entity.UserDetails;
import com.ge.survey.analytic.exception.SurveyAnaliticException;
import com.ge.survey.analytic.service.ISurveyAnalyticService;
import com.ge.survey.analytic.util.RestResponse;

//@RestController
@Controller
@RequestMapping(value = "/survey")
@Configuration
@ComponentScan("com.ge.survey.analytic.service")
public class SurveyAnalyticController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SurveyAnalyticController.class);
	 @Autowired
	 private ISurveyAnalyticService iSurveyAnalyticService;
	// private SurveyAnalyticRepository surveyRepo;

	@RequestMapping(value = "/getUserRegistration", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String createUser() throws SurveyAnaliticException {
		System.out.println("Inside method--");
		String result = null;
		List<RegestrationDTO> registrationList = new ArrayList<RegestrationDTO>();
		RegestrationDTO userDTO = new RegestrationDTO();
		
		UserDetails user = new UserDetails();
		user.setFirstName("Bhanumati");
		user.setLastName("Das");
		user.setAddress("Bhubaneswar");
		user.setCompanyName("Tech Mahindra");
		user.setEmail("bhanu.das85@gmail.com");
		user.setPhone("78799487998");
		
		System.out.println("New user created.............");
		UserDetails newUser = iSurveyAnalyticService.createUser(user);
		//UserDetails newUser= surveyRepo.save(user);
		result = "Success";
		System.out.println("User created: " + newUser.getUserId());
		

		/*if(newUser != null){
		userDTO.setResultStr("User Registered Successfully.");
		registrationList.add(userDTO);
		}else{
			userDTO.setResultStr("User Registration Failed.");
			registrationList.add(userDTO);
		}*/
		userDTO.setResultStr("User Registered Successfully.");
		registrationList.add(userDTO);
		return result;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String test() {
		
		return "Testing";
	}
	
	@RequestMapping(value = "/saveUserRegistration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public RestResponse createNewUser(@RequestBody @Valid final UserData user) throws SurveyAnaliticException {
		System.out.println("Inside createNewUser method--");
		RestResponse response=new RestResponse();
		try {
						
			UserData checkUser = iSurveyAnalyticService.findExistingUser(user.getUserName().toUpperCase());
			
			if(null != checkUser){
				response.setStatus(201);
				response.setMessage("Exists");
				//response.setObject(checkUser);
				return response;
			}else{
				//
				checkUser = new UserData() ;
				//TtUser user = new TtUser();
				checkUser.setUserName(user.getUserName().toUpperCase());
				//checkUser.setLastName(user.getLastName());
				checkUser.setEmail(user.getEmail());
				checkUser.setPassword(user.getPassword().toUpperCase());
				checkUser.setConfirmPassword(user.getConfirmPassword().toUpperCase());
				checkUser.setPhone(user.getPhone());
				iSurveyAnalyticService.createNewUser(checkUser);
				response.setStatus(200);
				response.setMessage("Success");
				//response.setObject(checkUser);
				return response;
			}
			
		}
		
		catch (Exception ex) {
			System.out.println("SurveyAnalyticController.createNewUser()");
			response.setStatus(201);
			response.setMessage("Failure");
			return response;
			
			
		}

	//	return status;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public RestResponse login(@RequestBody @Valid final UserData user) {
		RestResponse response=new RestResponse();
		try {

			UserData checkUser = iSurveyAnalyticService.findExistingUser(user.getUserName().toUpperCase());
			System.out.println("checkUser" + checkUser);

			if (null != checkUser) {

				if ((checkUser.getUserName().equalsIgnoreCase(user
						.getUserName()))
						&& (checkUser.getPassword().equalsIgnoreCase(user
								.getPassword()))) {
						//response.setObject(checkUser);
						response.setStatus(200);
						response.setMessage("Success");
						System.out.println("checkUser" + response);

				} else {
					response.setMessage("Failure");
					response.setStatus(201);

				}
				System.out.println("Response: "+ response);
			} else {
				response.setMessage("NotExist");
				response.setStatus(201);

			}

		}

		catch (Exception ex) {
			System.out.println("surveyAnalytic.login()");
			response.setStatus(201);
			return response;

		}
		// return status;
		return response;

	}
	

}
