package ga.crossover;

import java.util.ArrayList;
import java.util.Random;

import ga.Individual;

public class UniformCrossover extends Crossover {
	
	private float threshold=0.5f;
	
	public UniformCrossover(float threshold) {
		super();
		this.threshold = threshold;
	}

	@Override
	public ArrayList<Individual> crossover(Individual parent1, Individual parent2) {
		ArrayList<Integer> chromossome1 = parent1.getChromossome();
		ArrayList<Integer> chromossome2 = parent2.getChromossome();
		int size = chromossome1.size();
		
		
		Random random = new Random();
		float[] probabilityArray = new float[size];
		for(int i=0; i<size; i++) {
			probabilityArray[i] = random.nextFloat();
		}
		
		
		ArrayList<Individual> offspring = new ArrayList<Individual>();
		
		ArrayList<Integer> offspring1 = new ArrayList<Integer>();
		ArrayList<Integer> offspring2 = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++) {
			
			if (probabilityArray[i] > threshold ) {
				offspring1.add(chromossome1.get(i).intValue());
				offspring2.add(chromossome2.get(i).intValue());
			}else {
			offspring1.add(chromossome2.get(i).intValue());
			offspring2.add(chromossome1.get(i).intValue());
			}
		}
		
		offspring.add(new Individual(offspring1));
		offspring.add(new Individual(offspring2));
		
		return offspring;
		
	}

}
