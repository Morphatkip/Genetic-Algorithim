package com.za.tutorial.ga.cs;

public class Driver {
	public static final int POPULATION_SIZE =9;
	public static final double MUTATION_RATE =0.1; 
	public static final double CROSSOVER_RATE= 0.9;
	public static final int TOURNAMENT_SELECTION_SIZE=3;
	public static final int NUMB_OF_ELITE_SCHEDULES=1;
	private int schedulenumb= 0;
	private Data data;
  public static void main(String[] args) {
	Driver driver =new Driver();// instantiating the instance of this class
	driver.data =new Data();
	int generationnumber =0;
	driver.printAvailableData();
	System.out.println(" > Generation #" +generationnumber);
	System.out.println(" schedule #|                                                      ");
	System.out.println("classes [ dept,class, room ,instructor,meeting -time]             ");
	System.out.println("....................................................................");
	System.out.println(".....................................................................");
	GeneticAlgorithim geneticalgorithim =new GeneticAlgorithim(driver.data);
	Populaton population =new Populaton(Driver.POPULATION_SIZE,driver.data).sortByFitness();
	population.getShedule().forEach( Shedule -> System.out.println("        " +driver.schedulenumb++  +
			"     |" + Shedule +" |"
					+ String.format("%.5f",Shedule.getFitness())+
					"  |  " + Shedule.getNumberofconflicts()));
	
}
  private void printAvailableData() {
	  System.out.println("Available Departments ==>");
	  data.getDepts().forEach(x -> System.out.println("name :"+ x.getName()+",courses:" +x.getCourses()));
	  System.out.println("\n Availble courses ==>");
	  data.getCourses().forEach(x ->System.out.println("course #:" +x.getNumber()+",name:" +x.getName()
			  			+", max # of students :"+x.getMaxNumberOfStudents()+", instructors :" +x.getInstructors()));
	  System.out.println("\n Available rooms ==>");
	  data.getRooms().forEach( x -> System.out.println("room #"+x.getNumber()+", max seating capacity :"+x.getSeatingCapacity()));
	  System.out.println("\n Available Instructor ==>");
	  data.getInstructors().forEach(x -> System.out.println("id :"+x.getId()+",name :"+x.getName()));
	  System.out.println("\n Available meeting times ==>");
	  data.getMeetingTimes().forEach( x ->System.out.println("id :"+x.getId()+", meeting time"+x.getTime()));
	  System.out.println(".....................................................................................");
	  System.out.println("..........................................................................................");
	  }
}
