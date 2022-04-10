package com.kcguran.springreactedu.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.kcguran.springreactedu.shared.CurrentUser;
import com.kcguran.springreactedu.shared.Views;
import com.kcguran.springreactedu.user.IUserRepository;
import com.kcguran.springreactedu.user.User;

@RestController
public class AuthController {

	@Autowired
	IUserRepository userRepository;
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
		return ResponseEntity.ok(user);
	}
}
