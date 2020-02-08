package com.spring.segundoProjeto.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.spring.segundoProjeto.entity.User;
import com.spring.segundoProjeto.repository.UserRepository;

@Component
public class DataInitizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Fabrício", "fabricio.diniz@gmail.com");
			createUser("Kamyla", "Kamyla.bibiano@gmail.com");
			createUser("Holmes", "mr.holmes@gmail.com");
		}
		
		User user = userRepository.findByEmailQualquerCoisa("fabricio.diniz@gmail.com");
		System.out.println(user.getName());
	}
	
	public void createUser (String name, String email) {
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}
