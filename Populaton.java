package com.za.tutorial.ga.cs;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Populaton {
private ArrayList<shedule> Shedule;
public Populaton(int size ,Data data) {
	Shedule =new ArrayList<shedule>(size);
	//initialize shedules amd initializa and add them to the array
	IntStream.range(0,size).forEach (x -> Shedule.add(new shedule (data).initialize()));
	
}
public ArrayList<shedule> getShedule() {return Shedule;}
public Populaton sortByFitness() {
	Shedule.sort((Shedule1,Shedule2) -> {
	int returvalue =0;
	if (Shedule1.getFitness() > Shedule2.getFitness()) returvalue =-1;
	else if (Shedule1.getFitness() <Shedule2.getFitness()) returvalue =1;
	return returvalue;
	});
	return this;
}



}
