package com.sportsevent.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Message {
	
	private String id;
	private String text;
	private String userId;
	private String username;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
