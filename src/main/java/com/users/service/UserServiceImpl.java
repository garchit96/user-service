package com.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.entity.User;
import com.users.entity.Usergroup;
import com.users.exceptions.ResourceNotFoundException;
import com.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		 Optional<User> userId = userRepository.findById(user.getUser_id());
         
	        if(userId.isPresent()) 
	        {
	        	User userUpdate = userId.get();
	        	userUpdate.setName(user.getName());
	        	userUpdate.setEmail(user.getEmail());
	        	userUpdate.setAddress(user.getAddress());
	        	userUpdate.setUsergroup(user.getUsergroup());
	        	userUpdate = userRepository.save(userUpdate);
	            return userUpdate;
	        } 
	        else {
            throw new ResourceNotFoundException("Record not found with id : " + user.getUser_id());
        }
	}

	public String deleteUserById(Integer user_id) {
		Optional<User> user = userRepository.findById(user_id);
        
	       if(user.isPresent()) 
	       {
	    	   userRepository.deleteById(user_id);
	    	   return "User with id: " + user_id + " deleted successfully!";
	       } 
	       else {
	           throw new ResourceNotFoundException("Record not found with id : " + user_id);
	       }
   }

	@Override
	public User getUserById(Integer userId) {
		 Optional < User > user = this.userRepository.findById(userId);

	        if (user.isPresent()) {
	            return user.get();
	        }
	        else {
	            throw new ResourceNotFoundException("Record not found with id : " + userId);
	        }
	}

	@Override
	public List<User> getUsersByGroupId(Integer group_id) {
		// TODO Auto-generated method stub
		return userRepository.findAllUsersByGroupId(group_id);
	}

//	@Override
//	public Integer setGroupIdToNull(Integer group_id) {
//		return userRepository.updateGroupIdToNull(group_id);
//	} 
//	
	
	
}
