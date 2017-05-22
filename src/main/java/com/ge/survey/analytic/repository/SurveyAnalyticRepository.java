package com.ge.survey.analytic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.survey.analytic.entity.UserDetails;

@Repository
public interface SurveyAnalyticRepository extends JpaRepository<UserDetails, Long>{

	// findByuserId(@Param("userId") String userId);

}