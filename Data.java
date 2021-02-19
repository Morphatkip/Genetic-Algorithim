package com.za.tutorial.ga.cs;

import java.util.ArrayList;
import java.util.Arrays;

import com.za.tutorial.ga.cs.domain.Course;
import com.za.tutorial.ga.cs.domain.Department;
import com.za.tutorial.ga.cs.domain.Instructor;
import com.za.tutorial.ga.cs.domain.Meetingtime;
import com.za.tutorial.ga.cs.domain.Room;

public class Data {
	private ArrayList<Room> rooms;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList <Department> depts;
	private ArrayList<Meetingtime> meetingTimes;
	private int numberofclasses= 0;
	public Data() {initialize();}// the constructor will be calling the initialize method
	private Data initialize() {
		Room room1= new Room("R1",25);
		Room room2 = new Room ("R2",45);
		Room room3  = new Room("R3",35);
		
		rooms  = new ArrayList<Room>(Arrays.asList(room1,room2,room3));
		
		Meetingtime meetingtime1 =new Meetingtime("MT1","MWF 09:00-10:00");
		Meetingtime meetingtime2 =new Meetingtime("MT2","MWF 10:00-11:00");
		Meetingtime meetingtime3 =new Meetingtime("MT3","TTH 09:00-10:30");
		Meetingtime meetingtime4 =new Meetingtime("MT4","TTH 10:30-12:00");
		
		meetingTimes= new ArrayList<Meetingtime>(Arrays.asList(meetingtime1,meetingtime2,meetingtime3,meetingtime4));
		
		Instructor instructor1 = new Instructor("T1","Dr james Web");
		Instructor instructor2 =new Instructor("T2","Mr Mike brown");
		Instructor instructor3 = new Instructor("T3","Dr Steve Day");
		Instructor instructor4 = new Instructor("T4","Mrs jane Doe");
		instructors =new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4));
		
		
		Course course1 =new Course("C1","325k",new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)),25);
		Course course2 =new Course("C2","319k",new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3)),35);
		Course course3 =new Course("C3","462k",new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)),25);
		Course course4 =new Course("C4","464k",new ArrayList<Instructor>(Arrays.asList(instructor3,instructor4)),30);
		Course course5 =new Course("C5","360C",new ArrayList<Instructor>(Arrays.asList(instructor4)),35);
		Course course6 =new Course("C6","303k",new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)),45);
		Course course7 =new Course("C7","303l",new ArrayList<Instructor>(Arrays.asList(instructor2,instructor4)),45);
		
		courses= new ArrayList<Course> (Arrays.asList(course1,course2,course3,course4,course5,course6,course7));
		
		Department dept1 =new Department("Math" ,new ArrayList<Course>(Arrays.asList(course1,course3)));
		Department dept2 =new Department("EE" ,new ArrayList<Course>(Arrays.asList(course2,course4,course5)));
		Department dept3 =new Department("PHY" ,new ArrayList<Course>(Arrays.asList(course6,course7)));
		
		depts =new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3));
		depts.forEach(x->numberofclasses +=x.getCourses().size());
		return this;// this method returns the above data
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	
	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public ArrayList<Department> getDepts() {
		return depts;
	}
	
	public ArrayList<Meetingtime> getMeetingTimes() {
		return meetingTimes;
	}
	
	public int getNumberofclasses() {
		return numberofclasses;
	}
	
	
	
	

}
