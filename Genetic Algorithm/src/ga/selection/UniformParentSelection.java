package ga.selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import ga.Individual;

public class UniformParentSelection extends Selection {
	
	public UniformParentSelection() {
		super();
		
	}

	@Override
	public ArrayList<Individual> selection(ArrayList<Individual> individuals, int size, Comparator<Individual> comparator) {
		ArrayList<Individual> parents = new ArrayList<Individual>();
		
		Random random = new Random();
		
		for(int i = 0; i < size; i++) {
			
			parents.add(individuals.get(random.nextInt(individuals.size())));
			
		}
		
		return parents;
	}
	

}
