package com.shoppingList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingList.DTO.UserEditDTO;
import com.shoppingList.domain.User;
import com.shoppingList.repository.UserRepository;
import com.shoppingList.service.exceptions.ResourceNotFoundException;
import com.shoppingList.service.exceptions.WrongPasswordException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private User findUserById(Integer id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}
	
	public List<User> getAll() {
		return repo.findAll();
	}
	
	public User getOne(Integer id) {
		User user = findUserById(id);
		return user;
	}
	
	public User create(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		return repo.save(user);
	}
	
	public User edit(Integer id, UserEditDTO newUserData) {
		User user = findUserById(id);
		
		user.setName(newUserData.getName() != null ? newUserData.getName() : user.getName());
		user.setEmail(newUserData.getEmail() != null ? newUserData.getEmail() : user.getEmail());
			
		if(newUserData.getPassword() != null && newUserData.getOldPassword() != null) {
			if (bcrypt.matches(newUserData.getOldPassword(), user.getPassword())) {
				user.setPassword(bcrypt.encode(newUserData.getPassword()));
			} else {
				throw new WrongPasswordException("Incorrect old password");
			}
		}
		return repo.save(user);
	}
	
	public void destroy(Integer id) {
		findUserById(id);
		repo.deleteById(id);
	}
	
}