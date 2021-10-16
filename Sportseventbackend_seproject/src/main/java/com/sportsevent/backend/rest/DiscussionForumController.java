package com.sportsevent.backend.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportsevent.backend.entity.Event;
import com.sportsevent.backend.entity.Message;
import com.sportsevent.backend.entity.User;
import com.sportsevent.backend.service.DiscussionForumService;
import com.sportsevent.backend.service.EventService;
import com.sportsevent.backend.service.UserService;

//@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/forum/discussions")
public class DiscussionForumController {
	
	@Autowired
	DiscussionForumService discussionForumService;
	
	public DiscussionForumController(DiscussionForumService discussionForumService) {
		this.discussionForumService = discussionForumService;
	}
	
	@GetMapping(value = "/getallmessages")
	ResponseEntity<List<Message>> getMessages(){
		return ResponseEntity.status(HttpStatus.OK).body(discussionForumService.getMessages());
	}
	
	@PostMapping(value = "/saveMessage")
	ResponseEntity<Boolean> saveMessage(@RequestBody Message message){
		return ResponseEntity.status(HttpStatus.OK).body(discussionForumService.saveMessage(message));
	}

}
