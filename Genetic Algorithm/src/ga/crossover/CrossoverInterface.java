package ga.crossover;

import java.util.ArrayList;

import ga.Individual;

public interface CrossoverInterface {
	
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2);

}
