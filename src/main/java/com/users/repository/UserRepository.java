package com.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.users.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where group_id=?1")
	public List<User> findAllUsersByGroupId(Integer group_id);
	
//	@Query("select u from User u where groupName=?1")
//	public List<User> findAllUsersByGroupName(String groupName);
	
//	@Modifying
//	@Query("update User u set u.group_id=null where u.group_id =:n")
//	public Integer updateGroupIdToNull(@Param("n")Integer group_id);
}
