package com.musicsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.musicsite.domain.User;
import com.musicsite.services.UserService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		userService.createUser(new User("wafflemanox", "test"));
	}

}
