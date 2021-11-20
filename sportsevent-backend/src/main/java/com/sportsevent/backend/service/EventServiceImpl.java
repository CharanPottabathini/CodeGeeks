package com.sportsevent.backend.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import com.sportsevent.backend.entity.CreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsevent.backend.entity.Event;
import com.sportsevent.backend.entity.Participant;
import com.sportsevent.backend.entity.User;

@Service
public class EventServiceImpl implements EventService {

    private SportsEventComponent sportsEventComponent;

    @Autowired
    public EventServiceImpl(SportsEventComponent sportsEventComponent) {
        this.sportsEventComponent = sportsEventComponent;
    }

    @Override
    public List<Event> getEventDetails() {
        List<Event> eventList = new ArrayList<Event>();
        String participantSelect = "Select * from participant";
        Map<String, List<Participant>> participantMap = new HashMap<>();
        try {
            PreparedStatement participantSelectStatement = sportsEventComponent.getConnection().prepareStatement(participantSelect);
            ResultSet rs = participantSelectStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String eventId = rs.getString("event_id");
                Participant participant = new Participant();
                participant.setId(id);
                participant.setName(name);
                participant.setEventId(eventId);
                List<Participant> participantList = new ArrayList<Participant>();
                if (participantMap.containsKey(eventId)) {
                    participantList = participantMap.get(eventId);
                }
                participantList.add(participant);
                participantMap.put(eventId, participantList);
            }
            String selectEvent = "Select * from event";
            PreparedStatement eventStatement = sportsEventComponent.getConnection().prepareStatement(selectEvent);
            ResultSet resultSet = eventStatement.executeQuery();
            while (resultSet.next()) {
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


        String name = createEvent.getName().toUpperCase();
        String location = createEvent.getLocation().toLowerCase();
        String time = createEvent.getTime();
        Date date = (Date) createEvent.getDate();
        //Sat Jul 14 22:25:03 IST 2018


        String event_type = getEventType(date);

        String selectEventQuery = new StringBuilder().append("Select * FROM event where name =").append("\"").append(name).append("\"").append(" and date = ").append("\"").append(date).append("\"").append(" and location =").append("\"").append(location).append("\"").toString();
        System.out.println("the query is " + selectEventQuery);
        PreparedStatement selectStatement = sportsEventComponent.getConnection().prepareStatement(selectEventQuery);
        ResultSet resultset = selectStatement.executeQuery();


        while (resultset.next()) {
            System.out.println(resultMap + "returned");
            resultMap.put("isEventCreated", false);

            resultMap.put("message","error event already exists");
            return resultMap;

        }
        if (event_type.equals("NA")) {
            resultMap.put("isEventCreated", false);

            resultMap.put("message","error please enter correct date");
            return resultMap;
        }

        PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement("Select count(*) as count FROM event");
        ResultSet rs = statement.executeQuery();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        String insertEventQuery = "INSERT INTO event (id,name,location,time,date,event_type) VALUES (?,?,?,?,?,?)";
        PreparedStatement insertStatement = sportsEventComponent.getConnection().prepareStatement(insertEventQuery);
        insertStatement.setString(1, String.valueOf(id + 1));
        insertStatement.setString(2, name);
        insertStatement.setString(3, location);
        insertStatement.setString(4, time);
        insertStatement.setDate(5, date);
        insertStatement.setString(6, event_type.toUpperCase());
        insertStatement.execute();
        resultMap.put("isEventCreated", true);
        resultMap.put("message"," event created");

        System.out.println(resultMap + "returned");
        return resultMap;
    }

    @Override
    public Map joinEvent(Participant participant) throws SQLException {
        Map<String, Object> resultMap = new HashMap<>();


        int id = Integer.parseInt(participant.getId());
        String name = participant.getName();
        String participantEventId = participant.getEventId();


        String selectParticipantQuery = new StringBuilder().append("Select * FROM participant where name =").append("\"").append(name).append("\"").append(" and event_id = ").append(participantEventId).toString();
        System.out.println("the query is " + selectParticipantQuery);
        PreparedStatement selectStatement = sportsEventComponent.getConnection().prepareStatement(selectParticipantQuery);
        ResultSet resultset = selectStatement.executeQuery();


        while (resultset.next()) {
            System.out.println(resultMap + "returned");
            resultMap.put("isParticipantJoined", false);
            resultMap.put("message", "you joined the  event already");
            return resultMap;

        }
        PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement("Select count(*) as count FROM participant");
        ResultSet rs = statement.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        String insertEventQuery = "INSERT INTO participant (id,name,event_id) VALUES (?,?,?)";
        PreparedStatement insertStatement = sportsEventComponent.getConnection().prepareStatement(insertEventQuery);
        insertStatement.setString(1, String.valueOf(count+1));
        insertStatement.setString(2, name);
        insertStatement.setString(3, participantEventId);
        insertStatement.execute();
        resultMap.put("isParticipantJoined", true);

        System.out.println(resultMap + "returned");
        resultMap.put("message", "your has joined the  event successfully");

        return resultMap;    }




    public String getEventType(Date eventDate) {
        String eventType = "";
        java.util.Date date1 = eventDate;
        java.util.Date date2 = new java.util.Date(new java.util.Date().getTime() + 86400000);
        int diffInDays = (int) ((date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24));


        if (diffInDays > 7) {
            eventType = "Upcoming";
        } else if (diffInDays <= 7 && diffInDays > 0) {
            eventType = "Ongoing";
        } else {
            eventType = "NA";
        }
        return eventType;
    }

}