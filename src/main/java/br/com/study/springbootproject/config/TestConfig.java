package br.com.study.springbootproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.study.springbootproject.entities.User;
import br.com.study.springbootproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "marcus", "marcus@gmail.com", "54857864", "123");
		User u2 = new User(null, "vinicius", "vinicius@gmail.com", "33154534", "127");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
