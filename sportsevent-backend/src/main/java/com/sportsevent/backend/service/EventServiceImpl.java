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

import com.sportsevent.backend.entity.CreateEvent;
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
			String selectEvent = "Select * from event";
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

//	@Override
	public Map createEvent(CreateEvent createEvent) throws SQLException {

		Map<String, Object> resultMap = new HashMap<>();


        String name=createEvent.getName();
		String location=createEvent.getLocation();
		String time=createEvent.getTime();
		String event_type="";
		Date date= (Date) createEvent.getDate();
		String selecteventQuery = new StringBuilder().append("Select * FROM event where name =").append("\"").append(name).append("\"").append(" and date = ").append("\"").append(date).append("\"").append(" and location =").append("\"").append(location).append("\"").toString();
 		System.out.println("the query is "+selecteventQuery);
		PreparedStatement selectStatement = sportsEventComponent.getConnection().prepareStatement(selecteventQuery);
		ResultSet resultset = selectStatement.executeQuery();


		while(resultset.next())
		{
			System.out.println(resultMap+"returned");
			resultMap.put("error","event already exists");
			return resultMap;

		}


		PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement("Select count(*) as count FROM event");
		ResultSet rs = statement.executeQuery();
		int id = 0;
		if(rs.next()) {
			id = rs.getInt(1);
		}
		String inserteventQuery = "INSERT INTO event (id,name,location,time,date,event_type) VALUES (?,?,?,?,?,?)";
		PreparedStatement insertStatement = sportsEventComponent.getConnection().prepareStatement(inserteventQuery);
		insertStatement.setString(1, String.valueOf(id+1));
		insertStatement.setString(2, name);
		insertStatement.setString(3, location);
		insertStatement.setString(4, time);
		insertStatement.setDate(5, date);
		insertStatement.setString(6, event_type);
		insertStatement.execute();
		resultMap.put("Event is Registered",true);

System.out.println(resultMap+"returned");
       return resultMap;
	}

	}