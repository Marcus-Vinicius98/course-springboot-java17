package br.com.study.springbootproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.study.springbootproject.entities.Order;
import br.com.study.springbootproject.entities.User;
import br.com.study.springbootproject.entities.enums.OrderStatus;
import br.com.study.springbootproject.repositories.OrderRepository;
import br.com.study.springbootproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "marcus", "marcus@gmail.com", "54857864", "123");
		User u2 = new User(null, "vinicius", "vinicius@gmail.com", "33154534", "127");

		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-05-21T15:23:01Z"), OrderStatus.WAITING_PAYMENT, u2);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}

}
