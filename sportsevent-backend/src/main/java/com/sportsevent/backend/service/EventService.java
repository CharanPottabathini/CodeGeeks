package com.sportsevent.backend.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sportsevent.backend.entity.CreateEvent;
import com.sportsevent.backend.entity.Event;
import com.sportsevent.backend.entity.Participant;
import com.sportsevent.backend.entity.User;

public interface EventService {
	
	public List<Event> getEventDetails();
	public Map createEvent(CreateEvent createEvent) throws SQLException;

    public Map joinEvent(Participant participant) throws SQLException;;
}
