package com.za.tutorial.ga.cs;

import java.util.ArrayList;

import com.za.tutorial.ga.cs.domain.Class;
import com.za.tutorial.ga.cs.domain.Department;

public class shedule {
private ArrayList<Class> classes;
private int classNumber =0;
private int numberofconflicts =0;
private boolean isFitnessChanged = true;
private double fitness =-1;
private Data data;
public Data getData() {return data;}

public shedule(Data data) {
	this.data=data;
	classes=new ArrayList<Class>(data.getNumberofclasses());
	
}
public shedule initialize() {
	new ArrayList<Department>(data.getDepts()).forEach(dept ->{// picks up all the dapartments
		dept.getCourses().forEach(course ->{//picking up all the courses
     Class newClass =new Class(classNumber++ ,dept,course);//instantiate   a new class
     //randomly setting the meeting time
     newClass.setMeetingtime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size()*Math.random())));
     // randomly setting up  the rooms
     newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() *Math.random())));
     // randomly setting up the instructor
     newClass.setInstructor(course.getInstructors().get((int) (course.getInstructors().size()*Math.random())));
     classes.add(newClass);//adding the new arraylist to instant of classes
		});
	});
	return this; //return up the above shedule
		}

public int getNumberofconflicts() {return numberofconflicts;}
public ArrayList<Class> getClasses(){
	isFitnessChanged = true;
	return classes;
}
double getFitness() {//* originally was private
	if (isFitnessChanged == true) {
		fitness =calculatefitness();
		isFitnessChanged=false;
	}
	return fitness;
}

private double calculatefitness() {
	numberofconflicts=0;
	classes.forEach(x -> {// java eight to go through all the class
		if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents())  numberofconflicts++;
		classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
			if(x.getMeetingtime()== y.getMeetingtime() && x.getId() != y.getId()) { 
				if	(x.getRoom()== y.getRoom()) numberofconflicts ++;
				if (x. getInstructor()== y.getInstructor()) numberofconflicts++;
				
			}
		});
	});
	
	return 1/(double) (numberofconflicts+1);
}
public String toString() {
	String returnValue = new String();
	for( int x= 0;x<classes.size() -1; x++) returnValue += classes.get(x) + ",";
	returnValue += classes.get(classes.size()-1);
	return returnValue;
	
	
}

}
