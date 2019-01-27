package com.shoppingList.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingList.DTO.UserEditDTO;
import com.shoppingList.domain.User;
import com.shoppingList.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAll();
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getOne(@PathVariable Integer id){
		User user = userService.getOne(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> create(@Valid @RequestBody User user){
		User newUser = new User(null, user.getName(), user.getEmail(), user.getPassword());
		User createdUser = userService.create(newUser);
		return ResponseEntity.ok().body(createdUser);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> edit(@PathVariable Integer id, @Valid @RequestBody UserEditDTO user){
		User editedUser = userService.edit(id, user);
		return ResponseEntity.ok().body(editedUser);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> destroy(@PathVariable Integer id) {
		userService.destroy(id);
		return ResponseEntity.ok().build();
	}
}
