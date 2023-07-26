package com.jay.restapi.socialmediarestapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	private static List<User> users = new ArrayList <>();
	private static int idCounter = 1;
	
	static {
		users.add(new User(idCounter++,"Jay",LocalDate.now().minusYears(25)));
		users.add(new User(idCounter++,"Messi",LocalDate.now().minusYears(35)));
		users.add(new User(idCounter++,"Tyson",LocalDate.now().minusYears(21)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id){
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(idCounter++);
		users.add(user);
		return user;
	}
}
