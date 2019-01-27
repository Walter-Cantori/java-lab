package com.tutorial.app.ws.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.tutorial.app.ws.shared.Utils;
import com.tutorial.app.ws.ui.model.request.UserDetailRequestModel;
import com.tutorial.app.ws.ui.model.response.UserRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// Service annotation will be used by framework to identify which classes need to be initialized in the controller
// with DI
@Service
public class UserServiceImpl implements UserService {
  Map<String, UserRest> users;
  Utils utils;
  
  public UserServiceImpl() {
	  
  }
  
  @Autowired //spring will autowired utils in serviceimpl as serviceimpl class is not invloked with new to be passed with utils
  public UserServiceImpl(Utils utils) {
	  this.utils = utils;
  }

  @Override
  public UserRest createUser(UserDetailRequestModel userDetail) {
	UserRest returnValue = new UserRest();
	String userId = utils.generateUserId();
		
	returnValue.setEmail(userDetail.getEmail());
	returnValue.setFirstName(userDetail.getFirstName());
	returnValue.setLastName(userDetail.getLastName());
	returnValue.setUserId(userId);
		
	if (users == null) users = new HashMap<>();
    users.put(userId, returnValue);
    
    return returnValue;
  }

@Override
public UserRest getUser(String userId) {
	if (users.containsKey(userId)) {
		return users.get(userId);
	} else {
		return null;
	}
}

@Override
public Map<String, UserRest> getUsers() {
	return users;
}

}