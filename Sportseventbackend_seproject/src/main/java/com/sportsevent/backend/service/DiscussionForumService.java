package com.sportsevent.backend.service;

import java.util.List;

import com.sportsevent.backend.entity.Message;

public interface DiscussionForumService {
	
	public List<Message> getMessages();
	
	public boolean saveMessage(Message message);
	
}
