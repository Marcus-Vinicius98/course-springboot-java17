package br.com.study.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.springbootproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
