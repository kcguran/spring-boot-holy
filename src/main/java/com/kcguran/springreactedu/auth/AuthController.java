package com.kcguran.springreactedu.auth;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.kcguran.springreactedu.error.ApiError;
import com.kcguran.springreactedu.shared.Views;
import com.kcguran.springreactedu.user.IUserRepository;
import com.kcguran.springreactedu.user.User;

@RestController
public class AuthController {

	@Autowired
	IUserRepository userRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@RequestHeader(name="Authorization", required = false) String authorization) {
		if(authorization == null) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		String base64encoded = authorization.split("Basic ")[1];
		String decoded = new String(Base64.getDecoder().decode(base64encoded));
		String[] parts = decoded.split(":");
		String username = parts[0];
		String password = parts[1];
		User inDB = userRepository.findByUsername(username);
		if(inDB == null) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		String hashedPassword = inDB.getPassword();
		if(passwordEncoder.matches(password, hashedPassword)) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		return ResponseEntity.ok(inDB);
	}
}