package com.myapp.controller;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myapp.jwtutils.JwtUtil;
@RestController
@RequestMapping("/api")
public class HelloController {
	// Generate Token
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username){
		String token = JwtUtil.generateToken(username);
		return ResponseEntity.ok("Bearer " + token);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(Authentication authentication){
		String username = authentication.getName();
		return ResponseEntity.ok("Hello, " + username + "! You are authenticated.");
	}
	
	// Validate Token & Return hello message
//		@GetMapping("/hello") public ResponseEntity<?>hello(@RequestHeader("Authorization") String token){ 
//			try { 
//				String username = JwtUtil.validateToken(token); 
//				return ResponseEntity.ok("Hello, " + username +"!Your Token is valid."); 
//			} 
//			catch(Exception e) { 
//				return ResponseEntity.status(401).body("Invalid or experied token!!"); 
//			} 
//		}
}
