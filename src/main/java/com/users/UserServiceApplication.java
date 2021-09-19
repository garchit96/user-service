package com.users;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.users.repository.UsergroupRepository;

//import com.users.entity.User;
//import com.users.entity.UserMapping;
//import com.users.entity.Usergroup;

import com.users.repository.UserRepository;


@SpringBootApplication
//@EnableEurekaClient
public class UserServiceApplication {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsergroupRepository groupRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User user=new User("Raj","raj@gmail.com","Jaipur");
//		User user1=new User("Sam","sam@gmail.com","Delhi");
//		
//		Usergroup usergroup= new Usergroup("group1","group1@gmail.com");
//		Usergroup usergroup1= new Usergroup("group2","group2@gmail.com");
//		
//		UserMapping mapping1= new UserMapping();
//		mapping1.setUser(user);
//		mapping1.setUsergroup(usergroup);
//		
//		UserMapping mapping2= new UserMapping();
//		mapping2.setUser(user1);
//		mapping2.setUsergroup(usergroup1);
//		
//		
//		
//		this.userMappingRepository.save(mapping1);
//		this.userMappingRepository.save(mapping2);
		
//	}

}
