package ga.mutation;

import java.util.ArrayList;
import java.util.Random;

import ga.Individual;

public class SwapMutation extends Mutation {
	
	public SwapMutation(double mutationProbability, int range){
		super(mutationProbability, range);
	}

	@Override
	public void mutate(Individual individual) {
		Random random = new Random();
		ArrayList<Integer> chromossome = individual.getChromossome();
		
		double chance = random.nextDouble();
		
		if(super.mutationProbability >= chance) {
			
			int position1 = random.nextInt(range);
			int position2 = random.nextInt(range);
			
			int value1 = chromossome.get(position1).intValue();
			int value2 = chromossome.get(position2).intValue();
					
			chromossome.set(position1, value2);
			chromossome.set(position2, value1);
				
			
		}
		
	}

}
