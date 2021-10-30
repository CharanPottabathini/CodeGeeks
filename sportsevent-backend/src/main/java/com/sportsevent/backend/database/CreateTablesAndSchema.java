package com.sportsevent.backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CreateTablesAndSchema {
	
	public static void main(String[] args) {
		try(Connection conn = createNewDBconnection()){
			createSchemaAndTables(conn);
			System.out.println("Tables and schema created");
		}catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void createSchemaAndTables(Connection connection) {
		try {
			connection.prepareStatement("DROP SCHEMA if exists sports_event").execute();
			PreparedStatement statement = connection.prepareStatement("CREATE DATABASE sports_event"); 
			statement.execute();
			connection.setSchema("sports_event");
			String createUser = "CREATE TABLE sports_event.user ("+ 
					"					id varchar(25),"+ 
					"					username varchar(150)," + 
					"					password varchar(150)," +
					"					email varchar(150)," +
					"					phone varchar(150)," +
					"					Constraint PK Primary Key(id)"+ 
					"					)";
			String createEvent = "CREATE TABLE sports_event.event (" +
					"					id varchar(25),"+ 
					"					name varchar(150)," + 
					"					location varchar(150)," +
					"					time varchar(150)," +
					"					date date," +
					"					event_type varchar(150)," +
					"					Constraint PK Primary Key(id)"+ 
					")";
			String createParticipants = "CREATE TABLE sports_event.participant (" + 
					"					id varchar(25),"+ 
					"					name varchar(150)," + 
					"					event_id varchar(25)," +
					"					Constraint PK Primary Key(id),"+ 
					"					FOREIGN KEY (event_id) REFERENCES sports_event.event(id)"+
					")";
			String createMessage = "CREATE TABLE sports_event.message (" + 
					"					id varchar(25),"+ 
					"					text varchar(1000)," + 
					"					user_id varchar(25)," +
					"					time varchar(50)," +
					"					Constraint PK Primary Key(id),"+ 
					"					FOREIGN KEY (user_id) REFERENCES sports_event.user(id)"+
					")";
			connection.prepareStatement(createUser).execute();
			connection.prepareStatement(createEvent).execute();
			connection.prepareStatement(createParticipants).execute();
			connection.prepareStatement(createMessage).execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String dbhost = "jdbc:mysql://localhost:3306";
	private static String username = "root";
//	private static String password = "Shimsha06$";
	private static String password = "root";
	private static Connection conn;
	
	@SuppressWarnings("finally")
	public static Connection createNewDBconnection() {
		try  {	
			conn = DriverManager.getConnection(
					dbhost, username, password);	
		} catch (SQLException e) {
			System.out.println("Cannot create database connection");
			e.printStackTrace();
		} finally {
			return conn;	
		}		
	}
}
