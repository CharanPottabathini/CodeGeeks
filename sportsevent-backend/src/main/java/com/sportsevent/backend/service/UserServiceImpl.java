package com.sportsevent.backend.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsevent.backend.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private SportsEventComponent sportsEventComponent;
	
	@Autowired
	public UserServiceImpl(SportsEventComponent sportsEventComponent) {
		this.sportsEventComponent = sportsEventComponent;
	}

	@Override
	public boolean login(User user) {
		String select = "Select * from user where username = ? and password = ?";
		try {
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(select);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet rs = statement.executeQuery();
			return rs.next() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		String select = "Select count(*) as count FROM user";
		try {
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(select);
			ResultSet rs = statement.executeQuery();
			int id = 0;
			if(!rs.next()) {
				id = rs.getInt(1);
			}
			
			String insertQuery = "INSERT INTO user (id,username,password,email,phone) VALUES (?,?,?,?,?)";
			PreparedStatement insertStatement = sportsEventComponent.getConnection().prepareStatement(insertQuery);
			insertStatement.setString(1, String.valueOf(id+1));
			insertStatement.setString(2, user.getUsername());
			insertStatement.setString(3, user.getPassword());
			insertStatement.setString(4, user.getEmail());
			insertStatement.setString(5, user.getPhone());
			insertStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}

}
