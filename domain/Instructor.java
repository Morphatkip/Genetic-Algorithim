package com.za.tutorial.ga.cs.domain;

public class Instructor {
private String id;
private String name;
public Instructor(String name,String id) {
	this.id=id;
	this.name= name;
}
public String getId() {return id;}

public String getName() {return name;}

public String toString() {return name;}// return name of the instructor
}
