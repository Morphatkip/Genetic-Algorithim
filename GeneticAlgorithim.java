package com.za.tutorial.ga.cs;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GeneticAlgorithim {
	private Data data;
	public GeneticAlgorithim(Data data) {this.data =data;}
	
	public Populaton  evolve(Populaton population) { return mutatePopulation(crossoverPopulation(population));}
	Populaton crossoverPopulation(Populaton population) {
		Populaton crossoverPopulation =new Populaton(population.getShedule().size(),data);
		IntStream.range(0,Driver.NUMB_OF_ELITE_SCHEDULES).forEach(x -> crossoverPopulation.getShedule().set
		(x,population.getShedule().get(x)));
		
		IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES,population.getShedule().size()).forEach(x ->{
			if(Driver.CROSSOVER_RATE >Math.random()) {
				shedule Shedule1 =selectTournamentPopulation(population).sortByFitness().getShedule().get(0);
				shedule Shedule2 =selectTournamentPopulation(population).sortByFitness().getShedule().get(0);
				crossoverPopulation.getShedule().set(x, crossoverShedule(Shedule1,Shedule2));
			}else crossoverPopulation.getShedule().set(x, population.getShedule().get(x));
		});
			return crossoverPopulation;
	}
	shedule crossoverShedule(shedule Shedule1,shedule Shedule2) {
		shedule crossoverShedule= new shedule(data).initialize();
		IntStream.range(0, crossoverShedule.getClasses().size() ).forEach( x ->{
			if (Math.random()>0.5) crossoverShedule.getClasses().set(x, Shedule1.getClasses().get(x));
			else crossoverShedule.getClasses().set(x, Shedule2.getClasses().get(x));
		});
			return  crossoverShedule;
	}
	Populaton mutatePopulation(Populaton population) {
		Populaton mutatePopulation =new Populaton(population.getShedule().size(),data);
		ArrayList<shedule> schedules =mutatePopulation.getShedule();
		IntStream.range(0, Driver.NUMB_OF_ELITE_SCHEDULES).forEach
											( x -> schedules.set(x,population.getShedule().get(x)));
		IntStream.range(Driver.NUMB_OF_ELITE_SCHEDULES,population.getShedule().size() ).forEach(x -> {
		schedules.set(x,mutateShedule(population.getShedule().get(x)) );
		});
			return mutatePopulation;
	}
	shedule mutateShedule(shedule mutateShedule) {
		shedule  Shedule = new shedule (data).initialize();
		IntStream.range(0, mutateShedule.getClasses().size()).forEach(x->{
		if (Driver.MUTATION_RATE >Math.random()) mutateShedule.getClasses().set(x, Shedule.getClasses().get(x));
		});
			return mutateShedule;
		
	}
	Populaton selectTournamentPopulation(Populaton population) {
		Populaton tournamentPopulation =new Populaton(Driver.TOURNAMENT_SELECTION_SIZE,data);
		IntStream.range( 0, Driver.TOURNAMENT_SELECTION_SIZE).forEach(x -> {
		tournamentPopulation.getShedule().set(x, population.getShedule().get
				((int) (Math.random()* population.getShedule().size())));
		});
			return tournamentPopulation;
	}
}
