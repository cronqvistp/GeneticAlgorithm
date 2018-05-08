package ga.problem;

import java.util.ArrayList;
import java.util.Comparator;

import ga.Individual;
import ga.IndividualComparator;

public class QueenProblem extends Problem {

	public QueenProblem(String name, REPRESENTATION representation, Comparator<Individual> comparator, int size,
			float lowerBound, float upperBound) {
		super(name, representation, comparator, size, lowerBound, upperBound);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float fitness(Individual individual) {
		int hitCount = 0;
		ArrayList<Integer> chromossome = individual.getChromossome();
		
		for(int i = 0; i < size; i++) {
			int queenPosition = chromossome.get(i);
			for(int j = i + 1; j < size; j++) {
				int nextQueenPosition = chromossome.get(j);
				
				if(queenPosition == nextQueenPosition) {
					hitCount++;
					break;
				}
			}
		}
		
		for(int i = 0; i < size; i++) {
			int cell = 1;
			boolean leftHit = false;
			boolean rightHit = false;
			int queenPosition = chromossome.get(i);
			
			for(int j = i + 1; j < size; j++) {
				int nextQueenPosition = chromossome.get(j);
				
				if(nextQueenPosition == queenPosition + cell) {
					if(!rightHit) {
						hitCount++;
						rightHit = true;
						if(leftHit) {
							break;
						}
					}
				}
				
				else if(nextQueenPosition == queenPosition - cell) {
					if(!leftHit) {
						hitCount++;
						leftHit = true;
						if(rightHit) {
							break;
						}
					}
				}
				
				cell++;
			}
		}
		
		return hitCount;
	}

}
