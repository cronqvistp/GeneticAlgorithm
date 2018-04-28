package GA;

import java.util.ArrayList;
import java.util.Random;

public class RandomResettingMutation extends Mutation {
	
	public RandomResettingMutation(double mutationProbability, int range){
		super(mutationProbability, range);
	}

	@Override
	public void mutate(Individual individual) {
		Random random = new Random();
		ArrayList<Integer> chromossome = individual.getChromossome();
		
		for(int i = 0; i < chromossome.size(); i++) {
			double chance = random.nextDouble();
			if(super.mutationProbability <= chance) {
				chromossome.set(i, random.nextInt(range));
			}
		}
		
	}

}
