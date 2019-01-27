package com.shoppingList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppingList.domain.User;
import com.shoppingList.repository.UserRepository;
import com.shoppingList.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User usr = repo.findByEmail(email);
		
		if(usr == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(usr.getId(), usr.getEmail(), usr.getPassword());
	}

}
