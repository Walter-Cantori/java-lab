package com.cursomc.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityEnablerConfiguration{

//	@Autowired
//	private UserDetailsService userDetailsService;

	@Autowired
    private Environment env;

	@Autowired
	private JWTUtil jwtUtil;
}
