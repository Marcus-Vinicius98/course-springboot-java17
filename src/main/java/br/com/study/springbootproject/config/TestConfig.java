package br.com.study.springbootproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.study.springbootproject.entities.Category;
import br.com.study.springbootproject.entities.Order;
import br.com.study.springbootproject.entities.OrderItem;
import br.com.study.springbootproject.entities.Product;
import br.com.study.springbootproject.entities.User;
import br.com.study.springbootproject.entities.enums.OrderStatus;
import br.com.study.springbootproject.repositories.CategoryRepository;
import br.com.study.springbootproject.repositories.OrderItemRepository;
import br.com.study.springbootproject.repositories.OrderRepository;
import br.com.study.springbootproject.repositories.ProductRepository;
import br.com.study.springbootproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		User u1 = new User(null, "marcus", "marcus@gmail.com", "54857864", "123");
		User u2 = new User(null, "vinicius", "vinicius@gmail.com", "33154534", "127");

		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-05-21T15:23:01Z"), OrderStatus.WAITING_PAYMENT, u2);

		Product p1 = new Product(null, "Smart Tv", "Led", 3.200, "");
		Product p2 = new Product(null, "Video-Game", "Last Generation", 4.200, "");

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice());
		
		

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2));

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		productRepository.saveAll(Arrays.asList(p1, p2));
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2));
	}

}
