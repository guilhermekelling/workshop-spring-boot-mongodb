package com.guilhermerk.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilhermerk.workshopmongo.domain.Post;
import com.guilhermerk.workshopmongo.domain.User;
import com.guilhermerk.workshopmongo.dto.AuthorDTO;
import com.guilhermerk.workshopmongo.repository.PostRepository;
import com.guilhermerk.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		User maria = new User(null, "Guilherme Kelling", "guilhermekelling@gmail.com");
		User alex = new User(null, "Renato Silva", "rteste.silva@gmail.com");
		User bob = new User(null, "Fabio Jung", "fabio@cpagrupo.com");
		
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",  new AuthorDTO(maria));
	
		postReposiroty.saveAll(Arrays.asList(post1, post2));
	}

}