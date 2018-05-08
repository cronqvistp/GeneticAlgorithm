package ga.mutation;

public abstract class Mutation implements MutationInterface {
	
	protected double mutationProbability;
	protected int range;
	
	public Mutation(double mutationProbability, int range){
		this.mutationProbability = mutationProbability;
		this.range = range;
	}

}
