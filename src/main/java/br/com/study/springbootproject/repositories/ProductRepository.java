package br.com.study.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.springbootproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
