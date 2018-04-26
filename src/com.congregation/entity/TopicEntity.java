package com.congregation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Topics")
public class TopicEntity 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}
}
