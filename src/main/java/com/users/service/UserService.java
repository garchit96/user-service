package com.users.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.users.entity.User;

@Component
public interface UserService {
	
//	public List<User> saveUser(List<User> userList);
	public User addUser(User user);
	public List<User> getAllUser();
	public User getUserById(Integer userId);
	public User updateUser(User user);
	public String deleteUserById(Integer user_id);
	public List<User> getUsersByGroupId(Integer group_id); 
//	public Integer setGroupIdToNull(Integer group_id);
}
