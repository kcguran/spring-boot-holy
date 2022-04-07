package com.kcguran.springreactedu.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	IUserRepository userRepository;
	
	

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}



	public void save(User user) {
		userRepository.save(user);
	}
}
