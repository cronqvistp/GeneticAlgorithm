package GA;

public class Chromossome {
	private int fitness;
	private final int SIZE = 8;
	private int[] chromossome;
	private final double MUTATION_RATE = 0.5;
	private final int CROSSOVER_POINT = 3;
	
	public Chromossome() {
		init();
	}
	
	public Chromossome(int[] chromossome) {
		this.chromossome = chromossome;
	}
	
	private void init() {
		this.chromossome = new int[SIZE];
    	for (int i = 0; i < SIZE; i++){
    		this.chromossome[i] = (int) Math.floor(Math.random() * SIZE);
    	}
	}
	
	public void fitness() {
		int hitCount = 0;
		
		for(int i = 0; i < SIZE; i++) {
			int queenPosition = this.chromossome[i];
			for(int j = i + 1; j < SIZE; j++) {
				int nextQueenPosition = this.chromossome[j];
				
				if(queenPosition == nextQueenPosition) {
					hitCount++;
					break;
				}
			}
		}
		
		for(int i = 0; i < SIZE; i++) {
			int cell = 1;
			boolean leftHit = false;
			boolean rightHit = false;
			int queenPosition = this.chromossome[i];
			
			for(int j = i + 1; j < SIZE; j++) {
				int nextQueenPosition = this.chromossome[j];
				
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
		
		this.fitness = hitCount;
	}
	
	public void mutation() {
		if(Math.random() < MUTATION_RATE) {
			int point = (int) Math.floor(Math.random() * SIZE);
			int mutatedValue = (int) Math.floor(Math.random() * SIZE);
			this.chromossome[point] = mutatedValue;
		}
	}
	
	public Chromossome crossover(Chromossome parent) {
		int[] child = new int[SIZE];
		
		for(int i = 0; i <= CROSSOVER_POINT; i++) {
			child[i] = this.chromossome[i];
		}
		
		for(int i = CROSSOVER_POINT+1; i < SIZE ; i++) {
			child[i] = parent.getChromossome()[i];
		}
		
		return new Chromossome(child);
	}
	
	public int[] getChromossome() {
		return this.chromossome;
	}
	
	public int getFitness() {
		return fitness;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = true;
		if(obj instanceof Chromossome) {
			for(int i = 0; i < SIZE; i++) {
				if(this.chromossome[i] != ((Chromossome)obj).getChromossome()[i]) {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
}
