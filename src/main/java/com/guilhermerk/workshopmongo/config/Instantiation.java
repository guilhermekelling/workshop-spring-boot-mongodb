package com.guilhermerk.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilhermerk.workshopmongo.domain.User;
import com.guilhermerk.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		userReposiroty.deleteAll();

		User maria = new User(null, "Guilherme Kelling", "guilhermekelling@gmail.com");
		User alex = new User(null, "Renato Silva", "rteste.silva@gmail.com");
		User bob = new User(null, "Fabio Jung", "fabio@cpagrupo.com");

		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
	}

}