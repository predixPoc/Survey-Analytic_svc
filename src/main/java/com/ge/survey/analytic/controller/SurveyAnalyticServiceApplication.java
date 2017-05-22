package com.ge.survey.analytic.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages=("com.ge.survey.analytic.entity"))
@EnableJpaRepositories("com.ge.survey.analytic.repository")
public class SurveyAnalyticServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyAnalyticServiceApplication.class, args);
    }

    /**
     * Ensure the Tomcat container comes up, not the Jetty one.
     * @return - the factory
     */
    /*@Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory()
    {
        return new TomcatEmbeddedServletContainerFactory();
    }*/
    
}
