package br.com.study.springbootproject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.springbootproject.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(null, "Marcus", "marcus@gmail.com", "58748648", "1485");

		return ResponseEntity.ok().body(u);
	}

}
