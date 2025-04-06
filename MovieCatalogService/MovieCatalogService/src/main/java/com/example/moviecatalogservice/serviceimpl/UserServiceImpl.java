package com.example.moviecatalogservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.moviecatalogservice.entity.User;
import com.example.moviecatalogservice.repository.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createUser(User userDto) {
		// TODO Auto-generated method stub
		// userDto is not entity class here
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		User users = userDtoToEntity(userDto);// converted UsersDto into Users Class
		// User savedUser = userRepository.save(users);
		return userRepository.save(userDto);
	}

}
