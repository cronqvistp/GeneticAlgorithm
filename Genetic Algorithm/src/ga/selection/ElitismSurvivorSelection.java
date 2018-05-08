package ga.selection;

import java.util.ArrayList;
import java.util.Comparator;
import ga.Individual;

public class ElitismSurvivorSelection extends Selection {

	@Override
	public ArrayList<Individual> selection(ArrayList<Individual> population, int size, Comparator<Individual> comparator) {
		ArrayList<Individual> newPopulation = new ArrayList<Individual>(); 
		population.sort(comparator);
		
		for(int i = 0; i < size; i++) {
			newPopulation.add(population.get(i));
		}
		//System.out.println(newPopulation.get(0).getFitness() + " " + newPopulation.get(newPopulation.size()-1).getFitness());
		
		return newPopulation;
	}

}
