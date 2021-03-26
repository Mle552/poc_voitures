package com.etech.poc_voitures.services.applicatif.user;

import com.etech.poc_voitures.data.entity.User;
import com.etech.poc_voitures.services.repository.UserRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserSAImpl implements UserDetailsService, UserSA {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	String defaultUsername = "defaultuser";
	String defaultPassword = "P0cV@1tuR3";
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
		}
		throw new UsernameNotFoundException("Email username or password.");
	}
	
	
	@PostConstruct
	public void init() {
		importDefaultUser();
	}

	public void importDefaultUser() {
		User user = userRepository.findByUsername(defaultUsername);
		if (user == null) {
			user = new User();
			user.setUsername(defaultUsername);
			user.setPassword(passwordEncoder.encode(defaultPassword));
			userRepository.save(user);
		}
	}

}
