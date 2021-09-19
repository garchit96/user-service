package com.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.users.entity.User;
import com.users.entity.Usergroup;
import com.users.repository.UsergroupRepository;

@Component
public interface UsergroupService {
	
	public Usergroup addUsergroup(Usergroup usergroup);
	public List<Usergroup> getAllUsergroup();
	public Usergroup getUsergroupById(Integer groupId);
	public Usergroup updateUsergroup(Usergroup usergroup);
	public String deleteUsergroupById(Integer groupId);
	public String removeUsergroup(Integer groupId);
}
