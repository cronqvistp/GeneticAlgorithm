package GA;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testGA();
		for(int i = 0; i <= 10; i++) {
			System.out.println(new Random().nextInt(8-1) + 1);
		}
		
		
	}
	
	
	public static void testGA() {
		GeneticAlgorithm ga = new GeneticAlgorithm();
		Chromossome solution = ga.run();
		
		if(solution != null) {
			int[] positions = solution.getChromossome();
			System.out.print("Solution: ");
			for(int i = 0; i < positions.length; i++) {
				System.out.print(positions[i]);
			}
			
		}
	}
	
	public static void testFitness() {
        int[] solution = {0,1,2,3,4,5,6,7};
        Chromossome crom = new Chromossome(solution);
        
        crom.fitness();
        System.out.println(crom.getFitness());
    }

}
