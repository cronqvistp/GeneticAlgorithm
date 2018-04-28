package GA;

import java.util.ArrayList;

public class Individual {
	
	private ArrayList<Integer> chromossome;
	private int fitness;
	
	public Individual() {
		init();
		this.setFitness(Integer.MAX_VALUE);
	}
	
	public Individual(ArrayList<Integer> chromossome) {
		this.chromossome = chromossome;
		this.setFitness(Integer.MAX_VALUE);
	}
	
	private void init() {
		this.chromossome = new ArrayList<Integer>();
		int size = this.chromossome.size();
    	for (int i = 0; i < size; i++){
    		this.chromossome.set(i, (int) Math.floor(Math.random() * size));
    	}
	}
	
	public ArrayList<Integer> getChromossome(){
		return this.chromossome;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

}
