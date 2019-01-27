package com.tutorial.app.ws.userservice;

import java.util.Map;

import com.tutorial.app.ws.ui.model.request.UserDetailRequestModel;
import com.tutorial.app.ws.ui.model.response.UserRest;

public interface UserService {
  UserRest createUser(UserDetailRequestModel userDetail);
  UserRest getUser(String userId);
  Map<String, UserRest> getUsers();
}