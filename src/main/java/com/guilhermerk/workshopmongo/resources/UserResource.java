package com.guilhermerk.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermerk.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<User>> findAll() {
		User guilherme = new User("1", "Guilherme Kelling", "guilhermekelling@gmail.com");
		User renato = new User("2", "Alex Green", "guilherme@grupocpa.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(guilherme, renato));
		return ResponseEntity.ok().body(list);
	}
}