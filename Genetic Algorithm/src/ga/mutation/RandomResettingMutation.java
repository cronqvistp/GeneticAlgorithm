package ga.mutation;

import java.util.ArrayList;
import java.util.Random;

import ga.Individual;

public class RandomResettingMutation extends Mutation {
	
	public RandomResettingMutation(double mutationProbability, int range){
		super(mutationProbability, range);
	}

	@Override
	public void mutate(Individual individual) {
		Random random = new Random();
		ArrayList<Integer> chromossome = individual.getChromossome();
			
		double chance = random.nextDouble();
		if(super.mutationProbability >= chance) {
			
			chromossome.set(random.nextInt(range), random.nextInt(range));
		}
		
		
	}

}
