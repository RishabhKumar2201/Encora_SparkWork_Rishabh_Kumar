package com.myapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.jwtutils.JwtUtil;

@RestController
public class HelloController {

	@GetMapping("/api/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String role){
		String token = JwtUtil.generateToken(username, List.of(role));
		return ResponseEntity.ok("Bearer " + token);
	}
	
	@GetMapping("/api/hello")
	public String hello(Authentication auth) {
		return "Hello, " + auth.getName() + "! You are authorized.";
	}
	
	@GetMapping("/api/admin")
	public String admin(Authentication auth) {
		System.out.println("CallinG API....");
		return "Welcome Admin, " + auth.getName() + "! You have special access.";
	}
	
}
