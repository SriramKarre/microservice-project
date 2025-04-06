package com.example.movieratingservice.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody Login login) {
		org.springframework.security.core.Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtAuthResponse(token));
	}
}
