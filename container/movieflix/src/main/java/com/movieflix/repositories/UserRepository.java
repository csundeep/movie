package com.movieflix.repositories;

import org.springframework.data.repository.CrudRepository;

import com.movieflix.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {


	User findById(Long id);

	User findByEmail(String email);

}
