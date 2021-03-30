package com.etech.poc_voitures.services.applicatif.user;

import com.etech.poc_voitures.data.DAOUser;
import com.etech.poc_voitures.data.entity.User;
import com.etech.poc_voitures.services.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSAImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
		if (username.equals("user")) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new org.springframework.security.core.userdetails.User("user", "@dmiN123", roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
	}

}
