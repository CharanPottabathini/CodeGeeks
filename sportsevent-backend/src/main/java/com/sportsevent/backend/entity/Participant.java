package com.sportsevent.backend.entity;

public class Participant {
	
	private String id;
	private String name;
	private String eventId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Participant{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", eventId='" + eventId + '\'' +
				'}';
	}
}
