package ga.selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import ga.Individual;

public class TournamentParentSelection extends Selection {
	
	private int sampleNumber;
	
	public TournamentParentSelection(int sampleNumber) {
		super();
		this.sampleNumber = sampleNumber;
	}

	@Override
	public ArrayList<Individual> selection(ArrayList<Individual> individuals, int size, Comparator<Individual> comparator) {
		ArrayList<Individual> parents = new ArrayList<Individual>();
		
		for(int i = 0; i < size; i++) {
			int[] individualsIndices = randomSampling(size);
			
			int bestIndice = individualsIndices[0];
			float bestFitness = individuals.get(bestIndice).getFitness();
			
			for(int j = 1; j < individualsIndices.length; j++) {
				float fitness = individuals.get(individualsIndices[j]).getFitness();
				if(fitness > bestFitness) {
					bestFitness = fitness;
					bestIndice = individualsIndices[j];
				}
			}
			
			parents.add(individuals.get(bestIndice));
			
		}
		
		return parents;
	}
	
	private int[] randomSampling(int size) {
		Random random = new Random();
		int[] samples = new int[this.sampleNumber];
		for(int i = 0; i < this.sampleNumber; i++) {
			samples[i] = random.nextInt(size);
		}
		
		return samples;
	}

}
