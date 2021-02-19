package com.za.tutorial.ga.cs.domain;

public class Class {
private int id;
private Department dept;
private Course course;
private Instructor instructor;
private Meetingtime meetingtime;
private Room room;
public Class(int id,Department dept,Course course) {
	this.id= id;
	this.course= course;
	this.dept=dept;
	
}

public void setInstructor(Instructor instructor) {this.instructor = instructor;}

public void setMeetingtime(Meetingtime meetingtime) {this.meetingtime = meetingtime;}

public void setRoom(Room room) {this.room = room;}



public int getId() {return id;}

public Department getDept() {return dept;}

public Course getCourse() {return course;}

public Instructor getInstructor() {return instructor;}

public Meetingtime getMeetingtime() {return meetingtime;}

public Room getRoom() {return room;}
public String toString() {
	return"[" +dept.getName()+","+course.getNumber()+","+room.getNumber()+","+instructor.getId()+","+meetingtime.getId()+"]";
}


	
}
