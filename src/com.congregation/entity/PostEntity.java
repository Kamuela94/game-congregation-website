package com.congregation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class PostEntity 
{
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private String url;

	@ManyToOne(CascadeType.ALL)
	private int topic;
	
	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id=id;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public int getTopic(){
		return this.topic;
	}

	public void setTopic(int topic){
		this.topic = topic;
	}
}
