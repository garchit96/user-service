package com.users.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="usergroup")
public class Usergroup   {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer group_id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	private Date created_on=new Date();
	

	@OneToMany(mappedBy = "usergroup", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<User> users;
	
	
	public Usergroup(Integer group_id, String name, String email, Date created_on) {
		super();
		this.group_id = group_id;
		this.name = name;
		this.email = email;
		this.created_on = created_on;
	}
	
	public Usergroup( String name, String email) {
		super();
		
		this.name = name;
		this.email = email;
		
	}
	
	public Usergroup() {
		super();
	}

	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	
	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
