package ga;

import java.util.ArrayList;

import ga.crossover.Crossover;
import ga.mutation.Mutation;
import ga.problem.Problem;
import ga.selection.Selection;

public class GeneticAlgorithm2 {
	private Problem problem;
	private Crossover crossoverOperator;
	private Mutation mutationOperator;
	private Selection parentSelectionOperator;
	private Selection survivorSelectionOperator;
	
	private ArrayList<Individual> population;
	private int populationSize;
	private int parentsNumber;
	private Individual bestIndividual;
	private Individual currentGenerationBestIndividual;
	
	private String name = "";
	
	public GeneticAlgorithm2(Problem problem, Crossover crossover, Mutation mutation, Selection parentSelection, Selection survivorSelection, int populationSize, int parentsNumber) {
		this.problem = problem;
		this.crossoverOperator = crossover;
		this.mutationOperator = mutation;
		this.parentSelectionOperator = parentSelection;
		this.survivorSelectionOperator = survivorSelection;
		this.populationSize = populationSize;
		this.parentsNumber = parentsNumber;
	}
	
	private void initPopulation(){
		this.population = new ArrayList<Individual>();
		for(int i = 0; i < this.populationSize; i++) {
			this.population.add(this.problem.generateIndividual()); 
		}	
	}
	
	private void calculateFitness() {
		for(Individual i : this.population) {
			i.setFitness(this.problem.fitness(i));
		}
	}
	
	private void calculateIndividualFitness(Individual individual) {
		individual.setFitness(this.problem.fitness(individual));
	}
	

	public ArrayList<Float> run(int limit) {
		
		
		int iteration = 0;
		ArrayList<Individual> offSpring = new ArrayList<Individual>();
		ArrayList<Float> arrayBestSolutions = new ArrayList<Float>();
		
		this.initPopulation();
		this.calculateFitness();
		this.bestIndividual = this.population.get(0);
		
		while(iteration < limit) {
			
			offSpring.clear();
			
			ArrayList<Individual> parents = this.parentSelectionOperator.selection(this.population, this.parentsNumber, this.problem.getComparator());
			
			for(int i = 0; i < parents.size(); i+=2) {
				ArrayList<Individual> children = this.crossoverOperator.crossover(parents.get(i), parents.get(i+1));
				for(Individual child : children) {
					this.mutationOperator.mutate(child);
					this.calculateIndividualFitness(child);
					//System.out.println("child "+ child.getFitness());
				}
				offSpring.addAll(children);
			}
			
			this.population.addAll(offSpring);
			this.population = this.survivorSelectionOperator.selection(this.population, this.populationSize, this.problem.getComparator());
			
			this.population.sort(this.problem.getComparator());
			this.currentGenerationBestIndividual = this.population.get(0);
			
			arrayBestSolutions.add(this.population.get(0).getFitness());
			
			if(0 > this.problem.getComparator().compare(this.currentGenerationBestIndividual, this.bestIndividual)) {
				this.bestIndividual = this.currentGenerationBestIndividual;
				
				
				
			}
			
			
			
			
			
			/*for(int i = 1; i < this.population.size(); i++) {
				Individual individual = this.population.get(i);
				
				if(0 > this.problem.compare(individual, this.currentGenerationBestIndividual)) {
					this.currentGenerationBestIndividual = individual;
				}
			}
			
			if(0 > this.problem.compare(this.currentGenerationBestIndividual, this.bestIndividual)) {
				this.bestIndividual = this.currentGenerationBestIndividual;
			}*/
			
			//System.out.println(this.bestIndividual.getFitness());
			
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < this.bestIndividual.getChromossome().size(); i++) {
				sb.append(this.bestIndividual.getChromossome().get(i));
			}
			
			//System.out.println(sb.toString());
			
			
			
			//System.out.println(arrayBestSolutions);
			
			iteration++;
		}
		
	
		return arrayBestSolutions;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


}