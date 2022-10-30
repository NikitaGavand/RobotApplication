package com.codec.assessment.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.codec.assessment.robot.RobotNavigation;

@Configuration
@ComponentScan("com.codec.assessment")
public class RobotConfiguration {

	@Bean
	@ConfigurationProperties(prefix= "app")
	public RobotNavigation navigation() {
		return new RobotNavigation();
	}
}
