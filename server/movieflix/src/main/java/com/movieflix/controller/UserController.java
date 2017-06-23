package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.entities.User;
import com.movieflix.services.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public User findOne(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}")
	public User update(@PathVariable("id") Long id, @RequestBody User user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}