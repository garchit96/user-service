package com.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.users.entity.Usergroup;
@Repository
public interface UsergroupRepository extends JpaRepository<Usergroup, Integer> {

}
