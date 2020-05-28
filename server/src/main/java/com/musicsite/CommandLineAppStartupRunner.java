package com.musicsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.musicsite.dao.UserRepository;
import com.musicsite.domain.User;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(new User("wafflemanox", pwEncoder.encode("test")));
	}

}
