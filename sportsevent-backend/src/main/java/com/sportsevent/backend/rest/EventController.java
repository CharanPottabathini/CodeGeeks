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
import com.sportsevent.backend.entity.User;
import com.sportsevent.backend.service.EventService;
import com.sportsevent.backend.service.UserService;

//@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/sports")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping(value = "/events/ongoing")
	ResponseEntity<List<Event>> verifyOngoingEvents(){
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getEventDetails());
	}

	@GetMapping(value = "/events/upcoming")
	ResponseEntity<List<Event>> verifyUpcomingEvents(){
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getUpcomingEventDetails());
	}

}
