package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.User;

public interface UserService {

	List<User> findAll();

	User findById(Long id);

	User create(User usr);

	User update(Long id, User usr);

	void delete(Long id);

}
