package com.sportsevent.backend.service;

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

import com.sportsevent.backend.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private SportsEventComponent sportsEventComponent;
	
	@Autowired
	public UserServiceImpl(SportsEventComponent sportsEventComponent) {
		this.sportsEventComponent = sportsEventComponent;
	}

	@Override
	public Map login(User user) {
		//String select = "Select * from user where username = ? and password = ?";
		String select="Select * from user WHERE (phone = ? OR email = ?) and PASSWORD = ?";
		Map<String,Object> resultMap = new HashMap<>();
		try {
			
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(select);
			statement.setString(1, user.getPhone());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			System.out.println(statement);

			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				String userId = rs.getString("id");
				String userName=rs.getString("username");
				resultMap.put("loginStatus",true);
				resultMap.put("userId",userId);
				resultMap.put("username",userName);
			return resultMap;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map<String,Object> registerUser(User user) {
		Map<String,Object> resultMap = new HashMap<>();
		String select = "Select count(*) as count FROM user";
		String selectQuery = "Select * FROM user";
		List<String> userList = new ArrayList<>();
		List<String> emailList = new ArrayList<>();
		List<String> phoneList = new ArrayList<>();
		try {
			PreparedStatement selectStatement = sportsEventComponent.getConnection().prepareStatement(selectQuery);
			ResultSet resultset = selectStatement.executeQuery();
			while(resultset.next()){
				String username = resultset.getString("username");
				String email = resultset.getString("email");
				String phone = resultset.getString("phone");
				userList.add(username);
				emailList.add(email);
				phoneList.add(phone);
			}
			if(userList.contains(user.getUsername())){
				resultMap.put("error","username already exists");
				resultMap.put("isRegistered",false);
				return resultMap;
			}
			if(emailList.contains(user.getEmail())){
				resultMap.put("error","Email Id already exists");
				resultMap.put("isRegistered",false);
				return resultMap;
			}
			if(phoneList.contains(user.getPhone())){
				resultMap.put("error","Phone Number already exists");
				resultMap.put("isRegistered",false);
				return resultMap;
			}
			PreparedStatement statement = sportsEventComponent.getConnection().prepareStatement(select);
			ResultSet rs = statement.executeQuery();
			int id = 0;
			if(rs.next()) {
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
			resultMap.put("isRegistered",true);
			return resultMap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resultMap.put("isRegistered",false);
		return resultMap;
	}

}
