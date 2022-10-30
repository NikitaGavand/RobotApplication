package com.codec.assessment.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.codec.assessment.robot.RobotNavigation;

@SpringBootApplication
public class CodecApplication {
	@Autowired
	RobotNavigation robotNavigation;
		
	public static void main(String[] args) {
		SpringApplication.run(CodecApplication.class, args);
		try (ConfigurableApplicationContext ctx = SpringApplication.run(CodecApplication.class, args)) {
			CodecApplication app = ctx.getBean(CodecApplication.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String... args) throws Exception {
		System.out.println("The final position is "+robotNavigation.finalPosition());
    }

}
