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
import com.sportsevent.backend.entity.Message;
import com.sportsevent.backend.entity.Participant;
import com.sportsevent.backend.entity.User;

@Service
public class DiscussionForumServiceImpl implements DiscussionForumService{

	private SportsEventComponent sportsEventComponent;

	@Autowired
	public DiscussionForumServiceImpl(SportsEventComponent sportsEventComponent) {
		this.sportsEventComponent = sportsEventComponent;
	}

	@Override
	public List<Message> getMessages() {
		List<Message> messageList = new ArrayList<>();
		Map<String,String> usernameMap = new HashMap<>(); 
		String selectEvent = "Select * from message order by time";
		try {
			String userSelect = "Select * from user";
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(userSelect);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("username");
				usernameMap.put(id, name);
			}
			PreparedStatement messageStatement = sportsEventComponent.getConnection().prepareStatement(selectEvent);
			ResultSet resultSet = messageStatement.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String text = resultSet.getString("text");
				String userId = resultSet.getString("user_id");
				Date time = resultSet.getDate("time");
				Message message = new Message();
				message.setId(id);
				message.setText(text);
				message.setUserId(userId);
				message.setTime(time);
				message.setUsername(usernameMap.get(userId));
				messageList.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messageList;
	}

	@Override
	public boolean saveMessage(Message message) {
		String select = "Select count(*) as count FROM message";
		try {
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(select);
			ResultSet rs = statement.executeQuery();
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			String insertQuery = "INSERT INTO message (id,text,user_id,time) VALUES (?,?,?,CURRENT_TIMESTAMP)";
			PreparedStatement insertStatement = sportsEventComponent.getConnection().prepareStatement(insertQuery);
			insertStatement.setString(1, String.valueOf(id+1));
			insertStatement.setString(2, message.getText());
			insertStatement.setString(3, message.getUserId());
			insertStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
