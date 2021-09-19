package com.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.entity.User;
import com.users.entity.Usergroup;
import com.users.entity.Usergroup;
import com.users.exceptions.ResourceNotFoundException;
import com.users.repository.UserRepository;
import com.users.repository.UsergroupRepository;
import com.users.repository.UsergroupRepository;

@Service
public class UsergroupServiceImpl implements UsergroupService {

	@Autowired
	private UsergroupRepository usergroupRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Usergroup addUsergroup(Usergroup usergroup) {
		return usergroupRepository.save(usergroup);
	}

	@Override
	public List<Usergroup> getAllUsergroup() {
		return usergroupRepository.findAll();
	}

	@Override
	public Usergroup getUsergroupById(Integer groupId) {
		 Optional < Usergroup > group = this.usergroupRepository.findById(groupId);

	        if (group.isPresent()) {
	            return group.get();
	        }
	        else {
	            throw new ResourceNotFoundException("Record not found with id : " + groupId);
	        }
	}

	@Override
	public Usergroup updateUsergroup(Usergroup usergroup) {
		 Optional<Usergroup> groupId = usergroupRepository.findById(usergroup.getGroup_id());
         
	        if(groupId.isPresent()) 
	        {
	        	Usergroup groupUpdate = groupId.get();
	        	groupUpdate.setName(usergroup.getName());
	        	groupUpdate.setEmail(usergroup.getEmail());
	        	groupUpdate = usergroupRepository.save(groupUpdate);
	            return groupUpdate;
	        } 
	        else {
         throw new ResourceNotFoundException("Record not found with id : " + usergroup.getGroup_id());
     }
	}

	@Override
	public String deleteUsergroupById(Integer groupId) {
		Optional<Usergroup> group = usergroupRepository.findById(groupId);
        
	       if(group.isPresent()) 
	       {
	    	   usergroupRepository.deleteById(groupId);
	    	   return "Usergroup with id: " + groupId + " deleted successfully!";
	       } 
	       else {
	           throw new ResourceNotFoundException("Record not found with id : " + groupId);
	       }
	}

	@Override
	public String removeUsergroup(Integer groupId) {
		List<User> usersInGroup=userService.getUsersByGroupId(groupId);
		Optional<Usergroup> group = usergroupRepository.findById(groupId);
		if(group.isPresent()) {
			for(int i=0;i<usersInGroup.size();i++) {
				usersInGroup.get(i).setUsergroup(null);
				userService.addUser(usersInGroup.get(i));
//				System.out.println(usersInGroup.get(i));
			}
			
			usergroupRepository.deleteById(groupId);
			return "Usergroup with group_id: " + groupId + " deleted successfully!";
		}
		else {
	           throw new ResourceNotFoundException("Record not found with id : " + groupId);
	       }
	}

	
	

}
