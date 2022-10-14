package com.deevyanshu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String imgUrl;
	
	private int points;
	
	private int position;
	
	private Date date;
	
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String name, String imgUrl, int points, Date date,int position) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
		this.points = points;
		this.date = date;
		this.position=position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", points=" + points + ", date=" + date
				+ "]";
	}

	
	
	
	

}
