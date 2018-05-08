package ga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GeneticAlgorithm {
	private ArrayList<Chromossome> population;
	private final int POPULATION_SIZE = 100;
	private final int SOLUTION = 0;
	private final int ITERATIONS_LIMIT = 10000;
	private final int SELECTED_PARENTS_N = 5;
	private final int CROSSOVER_ITERATIONS = 50;
	
	public GeneticAlgorithm() {
		this.population = new ArrayList<Chromossome>();
	}
	
	public Chromossome run() {
		int iteration = 0;
		ArrayList<Chromossome> offSpring = new ArrayList<Chromossome>();
		initializePopulation();
		calculateFitness();
		
		while(iteration <= ITERATIONS_LIMIT) {
			iteration++;
			offSpring.clear();
			calculateFitness();
			for(int i = 0; i < CROSSOVER_ITERATIONS; i++) {
				Chromossome[] bestParents = parentSelection();
				Chromossome offSpring1 = bestParents[0].crossover(bestParents[1]);
				Chromossome offSpring2 = bestParents[1].crossover(bestParents[0]);
				offSpring1.mutation();
				offSpring1.fitness();
				offSpring2.mutation();
				offSpring2.fitness();
				offSpring.add(offSpring1);
				offSpring.add(offSpring2);
			}
			
			this.population.addAll(offSpring);
			generationSelection();
			System.out.println("Best Solution: "+this.population.get(0).getChromossome());
			
			Chromossome solution = checkSolution();
			
			if(solution != null) {
				System.out.println("Number of iterations: "+iteration);
				return solution;
			}
			
		}
		
		return null;
	}
	
	private void initializePopulation() {
		for(int i = 0; i < POPULATION_SIZE; i++) {
			this.population.add(new Chromossome());
		}
	}
	
	private void calculateFitness() {
		for(Chromossome c : this.population) {
			c.fitness();
		}
	}
	
	private Chromossome[] parentSelection() {
		ArrayList<Chromossome> selectedParents = new ArrayList<Chromossome>();
		Chromossome[] best2 = new Chromossome[2];
				
		for(int i = 0; i < SELECTED_PARENTS_N; i++) {
			int index = new Random().nextInt(100);
			Chromossome selectedParent = this.population.get(index);
			
			selectedParents.add(selectedParent) ;
		}
		
		selectedParents.sort(new Comparator<Chromossome>() {

			@Override
			public int compare(Chromossome o1, Chromossome o2) {
				return Integer.compare(o1.getFitness(), o2.getFitness());
				
			}
			
		});
		
		best2[0] = selectedParents.get(0);
		best2[1] = selectedParents.get(1);

		return best2;
	}
	
	
	
	private void generationSelection() {
		this.population.sort(new Comparator<Chromossome>() {

			@Override
			public int compare(Chromossome o1, Chromossome o2) {
				return Integer.compare(o1.getFitness(), o2.getFitness());
			}
			
		});
		
		for(int i = 0; i < CROSSOVER_ITERATIONS * 2; i++) {
			this.population.remove(this.population.size()-1);
		}
	}
	

	
	private Chromossome checkSolution() {
		for(Chromossome c : this.population) {
			if(c.getFitness() == SOLUTION) {
				return c;
			}
		}
		
		return null;
	}
	
	
	
}
