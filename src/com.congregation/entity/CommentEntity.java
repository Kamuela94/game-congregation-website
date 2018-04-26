package com.congregation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name="Posts")
public class PostEntity 
{
	@Id
	@GeneratedValue
	private int id;
	private String user;
	private String comment;
	private Calendar dateSent;

	@ManyToOne(CascadeType.ALL)
	private int topic;
	
	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id=id;
	}

	public String getUser(){
		return this.user;
	}

	public void setUser(String user){
		this.user=user;
	}

	public String getComment(){
		return this.comment;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public Calendar getDateSent(){
		return this.dateSent;
	}

	public void setDateSent(Calendar dateSent){
		this.dateSent = dateSent;
	}

	public int getTopic(){
		return this.topic;
	}

	public void setTopic(int topic){
		this.topic = topic;
	}
}
