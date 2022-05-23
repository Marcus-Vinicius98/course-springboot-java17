package br.com.study.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.springbootproject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
