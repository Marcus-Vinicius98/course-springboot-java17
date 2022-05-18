package br.com.study.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.springbootproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
