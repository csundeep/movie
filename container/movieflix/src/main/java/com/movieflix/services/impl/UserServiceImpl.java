package com.movieflix.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.entities.User;
import com.movieflix.exceptions.UserAlreadyExistsException;
import com.movieflix.exceptions.UserNotFoundException;
import com.movieflix.repositories.UserRepository;
import com.movieflix.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	public User findById(Long id) {
		User user = repository.findById(id);
		if (user == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return user;
	}

	@Transactional
	public User create(User user) {
		User userInDB = repository.findByEmail(user.getEmail());
		if (userInDB != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		return repository.save(user);
	}

	@Transactional
	public User update(Long id, User user) {
		User userInDB = repository.findById(id);
		if (userInDB == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return repository.save(user);
	}

	@Transactional
	public void delete(Long id) {
		User userInDB = repository.findById(id);
		if (userInDB == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		repository.delete(userInDB);
	}

}
