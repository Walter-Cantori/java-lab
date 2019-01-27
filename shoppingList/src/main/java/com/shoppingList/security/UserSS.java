package com.shoppingList.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String passoword;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {}
	
	
	
	public UserSS(Integer id, String email, String passoword) {
		super();
		this.id = id;
		this.email = email;
		this.passoword = passoword;
	}



	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return passoword;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
