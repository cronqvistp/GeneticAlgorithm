package ga;

import java.util.ArrayList;

public class Individual {
	
	private ArrayList<Integer> chromossome;
	private Float fitness;
	
	public Individual(ArrayList<Integer> chromossome) {
		this.chromossome = chromossome;
		this.fitness = null;
	}
	
	
	

	public void setChromossome(ArrayList<Integer> chromossome) {
		this.chromossome = chromossome;
	}




	public ArrayList<Integer> getChromossome(){
		return this.chromossome;
	}

	public Float getFitness() {
		return fitness;
	}

	public void setFitness(float fitness) {
		this.fitness = fitness;
	}

}
