package com.etech.poc_voitures.services.applicatif.user;

import com.etech.poc_voitures.data.DAOUser;
import com.etech.poc_voitures.data.dto.user.UserDTO;
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

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<SimpleGrantedAuthority> roles = null;
		
		DAOUser user = userDao.findByUsername(username);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
		
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}

}
