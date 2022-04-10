package com.kcguran.springreactedu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kcguran.springreactedu.user.User;
import com.kcguran.springreactedu.user.UserService;

@SpringBootApplication()
public class SpringReactEduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactEduApplication.class, args);
	}
	
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
				User user = new User();
				user.setUsername("user1");
				user.setDisplayName("display1");
				user.setPassword("P4ssword");
				userService.save(user);
			};
	}

}
