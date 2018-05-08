package ga.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import ga.Individual;
import ga.IndividualComparator;

public abstract class Problem implements ProblemInterface {

	protected String name;
	protected REPRESENTATION representation;
	protected Comparator comparator;
	protected int size;
	protected float lowerBound;
	protected float upperBound;
	
	public Problem(String name, REPRESENTATION representation, Comparator<Individual> comparator, int size, float lowerBound, float upperBound) {
		this.name = name;
		this.representation = representation;
		this.comparator = comparator;
		this.size = size;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		
	}
	
	public Individual generateIndividual() {
		ArrayList<Integer> chromossome = new ArrayList<Integer>();
		
		for(int i = 0; i < this.size; i++) {
			chromossome.add((int)this.random());
		}
		
/*		if(new Random().nextInt(2) == 0) {
			chromossome = new ArrayList<Integer>();
			chromossome.add(0);
			chromossome.add(4);
			chromossome.add(7);
			chromossome.add(5);
			chromossome.add(2);
			chromossome.add(6);
			chromossome.add(1);
			chromossome.add(3);
		}*/
		
/*		chromossome = new ArrayList<Integer>();
		for(int i = 0; i < this.size; i++) {
			chromossome.add(i);
		}*/
		
		Collections.shuffle(chromossome);
		
		return new Individual(chromossome);
	}
	
	public float random() {
		Random random = new Random();
		
		switch(this.representation) {
			case INTEGER:
				return random.nextInt((int) this.upperBound - (int) this.lowerBound) + (int) this.lowerBound;
			
			case REAL:
				return this.lowerBound + (this.upperBound - this.lowerBound) * random.nextFloat();
			
			case BINARY:
				return random.nextInt(2);
			
			default:
				return 0;
		}
		
	}
	
	public Comparator getComparator() {
		return this.comparator;
	}

}
