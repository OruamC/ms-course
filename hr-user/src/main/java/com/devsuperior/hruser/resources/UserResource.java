package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

@Controller
@RequestMapping("/users")
public class UserResource {

	private UserRepository repository;

	@Autowired
	public UserResource(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = this.repository.findById(id).get();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User user = this.repository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}