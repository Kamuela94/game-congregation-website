package com.congregation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserEntity 
{
	@Id
	@GeneratedValue
	private String username;
	private String password;
	private String token
	
	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getToken(){
		return this.token;
	}

	public void setToken(String token){
		this.token = token;
	}
}
