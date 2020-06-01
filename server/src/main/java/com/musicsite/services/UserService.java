package com.musicsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.musicsite.dao.UserRepository;
import com.musicsite.domain.User;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
	}

	public boolean createUser(User user) {
		if(userRepo.existsById(user.getUsername())) {
			return false;
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return (userRepo.save(user) != null);
	}
	
}
