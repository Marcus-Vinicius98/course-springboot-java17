package br.com.study.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.springbootproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
