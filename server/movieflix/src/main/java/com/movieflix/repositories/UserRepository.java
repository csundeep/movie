package com.movieflix.repositories;

import java.util.List;

import com.movieflix.entities.User;

public interface UserRepository {

	List<User> findAll();

	User findById(Long id);

	User findByEmail(String email);

	User create(User emp);

	User update(User emp);

	void delete(User existing);

}
