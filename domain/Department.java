package com.za.tutorial.ga.cs.domain;

import java.util.ArrayList;

public class Department {
private String name;// name of the department
private ArrayList<Course> courses;// courses offered
public Department(String name,ArrayList<Course> courses) {
	this.name=name;
	this.courses=courses;
	
}
public String getName() {return name;}

public ArrayList<Course> getCourses() {return courses;}
}
