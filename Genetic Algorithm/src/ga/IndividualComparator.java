package ga;
import java.util.Comparator;
import ga.problem.OPTIMIZATION;

public class IndividualComparator implements Comparator<Individual> {
	
	private OPTIMIZATION optimization;
	
	public IndividualComparator(OPTIMIZATION optimization) {
		this.optimization = optimization;
	}

	@Override
	public int compare(Individual individual1, Individual individual2) {
		int value = Float.compare(individual1.getFitness() , individual2.getFitness());
		
		if(optimization == OPTIMIZATION.MAXIMIZATION) {
			return value*-1;
		}
		
		return value;
	}

}
