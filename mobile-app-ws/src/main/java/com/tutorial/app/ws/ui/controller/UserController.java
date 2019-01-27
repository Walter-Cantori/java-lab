package com.tutorial.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.tutorial.app.ws.ui.model.request.UpdateUserDetailRequestModel;
import com.tutorial.app.ws.ui.model.request.UserDetailRequestModel;
import com.tutorial.app.ws.ui.model.response.UserRest;
import com.tutorial.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users") // http:/localhost:8080/users/
public class UserController {
	
	Map<String, UserRest> users;

	@Autowired
	UserService userService;
	
	@GetMapping
	public Map<String, UserRest> getUsers(
			@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="10") int limit,
			@RequestParam(value="sort", defaultValue="desc") String sort
	) {
		return userService.getUsers();
	}
	
	@GetMapping(path="/{userId}", produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		returnValue.setEmail("foo@gmail.com");
//		returnValue.setFirstName("foo");
//		returnValue.setLastName("bar");
//		returnValue.setUserId("1234");
		
		UserRest returnValue = userService.getUser(userId);
		if (returnValue != null) {
			return new ResponseEntity<>(returnValue, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PostMapping(
			produces = {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
			},
			consumes = {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetail) {

		UserRest returnValue = userService.createUser(userDetail);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(
			path="/{userId}",
			consumes = {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
			}, produces = {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
			}
	)
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailRequestModel userDetail) {
		UserRest returnValue = users.get(userId);
		
		returnValue.setFirstName(userDetail.getFirstName());
		returnValue.setLastName(userDetail.getLastName());
		users.put(userId, returnValue);
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}

}
