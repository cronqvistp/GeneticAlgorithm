package GA;

import java.util.ArrayList;
import java.util.Random;

public class OnePointCrossover extends Crossover {
	
	public OnePointCrossover() {
		super();
	}

	@Override
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2) {
		ArrayList<Integer> chromossome1 = parent1.getChromossome();
		ArrayList<Integer> chromossome2 = parent2.getChromossome();
		int size = chromossome1.size();
		
		Random random = new Random();
		int crossoverPoint = random.nextInt(size-1) + 1;
		
		ArrayList<Individual> offspring = new ArrayList<Individual>();
		
		ArrayList<Integer> offspring1 = new ArrayList<Integer>();
		ArrayList<Integer> offspring2 = new ArrayList<Integer>();
		for(int i = 0; i < crossoverPoint; i++) {
			offspring1.add(chromossome1.get(i).intValue());
			offspring2.add(chromossome2.get(i).intValue());
		}
		
		for(int i = crossoverPoint; i < size; i++) {
			offspring1.add(chromossome2.get(i).intValue());
			offspring2.add(chromossome1.get(i).intValue());
		}
		
		offspring.add(new Individual(offspring1));
		offspring.add(new Individual(offspring2));
		
		return offspring;
		
	}

}
