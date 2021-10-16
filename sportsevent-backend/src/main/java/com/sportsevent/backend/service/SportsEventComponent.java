package com.sportsevent.backend.service;

import java.sql.Connection;

import org.springframework.stereotype.Component;

import com.sportsevent.backend.database.DBConnection;

@Component
public class SportsEventComponent {
	
	private Connection conn;
	
	public SportsEventComponent() {
		this.conn = DBConnection.createNewDBconnection();
	}

	public Connection getConnection() {
		return conn;
	}

}
