package com.sportsevent.backend.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsevent.backend.entity.Event;
import com.sportsevent.backend.entity.Participant;
import com.sportsevent.backend.entity.User;

@Service
public class EventServiceImpl implements EventService{
	
	private SportsEventComponent sportsEventComponent;
	
	@Autowired
	public EventServiceImpl(SportsEventComponent sportsEventComponent) {
		this.sportsEventComponent = sportsEventComponent;
	}

	@Override
	public List<Event> getEventDetails() {
		List<Event> eventList = new ArrayList<Event>();
		String participantSelect = "Select * from participant";
		Map<String,List<Participant>> participantMap = new HashMap<>();
		try {
			PreparedStatement participantSelectStatement = sportsEventComponent.getConnection().prepareStatement(participantSelect);
			ResultSet rs = participantSelectStatement.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String eventId = rs.getString("event_id");
				Participant participant = new Participant();
				participant.setId(id);
				participant.setName(name);
				participant.setEventId(eventId);
				List<Participant> participantList = new ArrayList<Participant>(); 
				if(participantMap.containsKey(eventId)) {
					participantList = participantMap.get(eventId);
				}
				participantList.add(participant);
				participantMap.put(eventId,participantList);
			}
			String selectEvent = "Select * from event where event_Type="+"'ONGOING'";
			PreparedStatement eventStatement = sportsEventComponent.getConnection().prepareStatement(selectEvent);
			ResultSet resultSet = eventStatement.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String location = resultSet.getString("location");
				String time = resultSet.getString("time");
				String eventType = resultSet.getString("event_type");
				Date date = resultSet.getDate("date");
				List<Participant> participants = participantMap.get(id) == null ? 
						new ArrayList<Participant>() : participantMap.get(id);
				Event event = new Event();
				event.setId(id);
				event.setName(name);
				event.setLocation(location);
				event.setTime(time);
				event.setEventType(eventType);
				event.setDate(date);
				event.setParticipants(participants);
				eventList.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public List<Event> getUpcomingEventDetails() {
		List<Event> eventList = new ArrayList<Event>();
		String participantSelect = "Select * from participant";
		Map<String,List<Participant>> participantMap = new HashMap<>();
		try {
			PreparedStatement participantSelectStatement = sportsEventComponent.getConnection().prepareStatement(participantSelect);
			ResultSet rs = participantSelectStatement.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String eventId = rs.getString("event_id");
				Participant participant = new Participant();
				participant.setId(id);
				participant.setName(name);
				participant.setEventId(eventId);
				List<Participant> participantList = new ArrayList<Participant>();
				if(participantMap.containsKey(eventId)) {
					participantList = participantMap.get(eventId);
				}
				participantList.add(participant);
				participantMap.put(eventId,participantList);
			}
			String selectEvent = "Select * from event where event_Type="+"'UPCOMING'";
			PreparedStatement eventStatement = sportsEventComponent.getConnection().prepareStatement(selectEvent);
			ResultSet resultSet = eventStatement.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String location = resultSet.getString("location");
				String time = resultSet.getString("time");
				String eventType = resultSet.getString("event_type");
				Date date = resultSet.getDate("date");
				List<Participant> participants = participantMap.get(id) == null ?
						new ArrayList<Participant>() : participantMap.get(id);
				Event event = new Event();
				event.setId(id);
				event.setName(name);
				event.setLocation(location);
				event.setTime(time);
				event.setEventType(eventType);
				event.setDate(date);
				event.setParticipants(participants);
				eventList.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}
}
