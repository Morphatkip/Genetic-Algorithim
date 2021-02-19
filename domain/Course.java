package com.za.tutorial.ga.cs.domain;

import java.util.ArrayList;

public class Course {
	private String name = null;
	private String number= null;
	private int maxNumberOfStudents;
	private ArrayList<Instructor> instructors;
	public Course(String name,String number,ArrayList<Instructor> instructors,int maxNumberOfStudents) {
		this.name =name;
		this.number=number;
		this.instructors=instructors;
		this.maxNumberOfStudents=maxNumberOfStudents;
	}
	
	public String getName() {return name;}
	
	public String getNumber() {return number;}
	
	public int getMaxNumberOfStudents() {return maxNumberOfStudents;}
	
	public ArrayList<Instructor> getInstructors() {return instructors;}
	public String toString() {return name;} // return name of the course
	
	

}
