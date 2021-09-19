package com.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.users.entity.User;

import com.users.entity.Usergroup;

import com.users.repository.UserRepository;
import com.users.repository.UsergroupRepository;
import com.users.service.UsergroupService;
import com.users.service.UserService;


@RestController
@RequestMapping("/service")
@CrossOrigin
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UsergroupService usergroupService;
	
	
//	-----------------User Controller ------------------------------
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
    public ResponseEntity < User > findUserById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
	
	@GetMapping("/users/ofGroup/{group_id}")
    public ResponseEntity <List< User > >getUsersByGroupId(@PathVariable Integer group_id) {
        return ResponseEntity.ok().body(userService.getUsersByGroupId(group_id));
    }
	
	@PostMapping("/users/addUser")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/users/updateUser/{id}")
    public ResponseEntity<User> updateUserDet(@PathVariable(name = "id") Integer user_id,
            @RequestBody User user) {
		user.setUser_id(user_id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }
	
//	@PutMapping("/users/updateGroupId/{id}")
//    public ResponseEntity<Integer> updateGroupIdToNull(@PathVariable(name = "id") Integer group_id,
//            @RequestBody User user) {
//		user.getUsergroup().setGroup_id(group_id);
//        return ResponseEntity.ok().body(this.userService.setGroupIdToNull(group_id));
//    }
	
	 @DeleteMapping("/users/deleteUser/{id}")
	    public ResponseEntity<String> removeUser(@PathVariable(name = "id") Integer userId) {
	        String message = userService.deleteUserById(userId);
	        return new ResponseEntity<>(message, HttpStatus.OK);
	    }
	 
	 
	 
//	 --------------------------group Controller -----------------------------
	
	 @GetMapping("/usergroups")
		public ResponseEntity<List<Usergroup>> getUsergroups() {
			return new ResponseEntity<>(usergroupService.getAllUsergroup(), HttpStatus.OK);
		}
		
		@GetMapping("/usergroups/{id}")
	    public ResponseEntity < Usergroup > findUsergroupById(@PathVariable Integer id) {
	        return ResponseEntity.ok().body(usergroupService.getUsergroupById(id));
	    }
		
		@PostMapping("/usergroups/addUsergroup")
		public Usergroup saveUsergroup(@RequestBody Usergroup usergroup) {
			return usergroupService.addUsergroup(usergroup);
		}
		
		@PutMapping("/usergroups/updateUsergroup/{id}")
	    public ResponseEntity<Usergroup> updateGroupDet(@PathVariable(name = "id") Integer group_id,
	            @RequestBody Usergroup group) {
			group.setGroup_id(group_id);
	        return ResponseEntity.ok().body(this.usergroupService.updateUsergroup(group));
	    }
		
//		 @DeleteMapping("/usergroups/deleteUsergroup/{id}")
//		    public ResponseEntity<String> deleteUsergroup(@PathVariable(name = "id") Integer groupId) {
//		        String message = usergroupService.deleteUsergroupById(groupId);
//		        return new ResponseEntity<>(message, HttpStatus.OK);
//		    }
		 
		 @DeleteMapping("/usergroups/removeUsergroup/{id}")
		    public ResponseEntity<String> removeUsergroup(@PathVariable(name = "id") Integer groupId) {
		        String message = usergroupService.removeUsergroup(groupId);
		        return new ResponseEntity<>(message, HttpStatus.OK);
		    }
		 
		 
//		 --------------------------- 
	

	
	 
	
}
