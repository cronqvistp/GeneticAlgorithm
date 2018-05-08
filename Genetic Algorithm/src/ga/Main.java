package ga;

import java.awt.Color;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.Comparator;

import ga.crossover.Crossover;
import ga.crossover.OnePointCrossover;
import ga.crossover.UniformCrossover;
import ga.mutation.Mutation;
import ga.mutation.RandomResettingMutation;
import ga.mutation.SwapMutation;
import ga.problem.OPTIMIZATION;
import ga.problem.Problem;
import ga.problem.QueenProblem;
import ga.problem.REPRESENTATION;
import ga.selection.ElitismSurvivorSelection;
import ga.selection.Selection;
import ga.selection.TournamentParentSelection;
import ga.selection.UniformParentSelection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testGA();	
		//testGA2();
		/*for(int i = 0; i <10; i++) {
			Chromossome c = new Chromossome();
			int[] array = c.getChromossome();
		}*/
	    
		resultsGA();
		//testMutations();
		//testCrossovers();
	   
	   
		
	}
	
	private static void testCrossovers(){
		Individual ind1 = new Individual(null);
		Individual ind2 = new Individual(null);
		ArrayList<Individual> offs = new ArrayList<Individual>();
		
		ArrayList<Integer> chromossome = new ArrayList<Integer>();
		ArrayList<Integer> chromossome2 = new ArrayList<Integer>();
		
		
		//Crossover onePointCrossover = new OnePointCrossover();
		Crossover uniformCrossover = new UniformCrossover(0.5f);
		
		chromossome = new ArrayList<Integer>();
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		chromossome.add(0);
		
		chromossome2 = new ArrayList<Integer>();
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		chromossome2.add(2);
		
		ind1.setChromossome(chromossome);
		ind2.setChromossome(chromossome2);
		
		//ArrayList<Individual> children = onePointCrossover.crossover(ind1, ind2);
		ArrayList<Individual> children = uniformCrossover.crossover(ind1, ind2);
		
		StringBuilder sb = new StringBuilder();
		for (Individual child : children) {
			for(int i = 0; i < 8; i++) {
				sb.append(child.getChromossome().get(i));
			}
			
			System.out.println(sb.toString());
			
		}
		

		
		//System.out.println(sb.toString());
		
		
		
		
		
	}
	
	
	private static void testMutations(){
		
		Individual ind = new Individual(null);
		
		
		ArrayList<Integer> chromossome = new ArrayList<Integer>();
		//Mutation swapMutation = new SwapMutation(0.1, 8);
		Mutation randomMutation = new RandomResettingMutation(0.1, 8);
		
		chromossome = new ArrayList<Integer>();
		chromossome.add(0);
		chromossome.add(1);
		chromossome.add(2);
		chromossome.add(3);
		chromossome.add(4);
		chromossome.add(5);
		chromossome.add(6);
		chromossome.add(7);
		
		ind.setChromossome(chromossome);
		
		//swapMutation.mutate(ind);
		randomMutation.mutate(ind);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			sb.append(ind.getChromossome().get(i));
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void resultsGA() {
		String name = "Results";
		REPRESENTATION representation = REPRESENTATION.INTEGER;
		int size = 8;
		float lowerBound = 0;
		float upperBound = 7;
		
		int populationSize = 100;
		int parentsNumber = 50;
		int limit = 300;
		
		int nExperiments = 50;
		
		Comparator<Individual> comparator = new IndividualComparator(OPTIMIZATION.MINIMIZATION);
		Problem problem = new QueenProblem(name, representation, comparator, size, lowerBound, upperBound);
		
		Crossover onePointCrossover = new OnePointCrossover();
		Crossover uniformCrossover = new UniformCrossover(0.5f);
		
		Mutation swapMutation = new SwapMutation(0.5, size);
		Mutation randomSMutation = new RandomResettingMutation(0.5, size);
		
		Selection parentSelection = new TournamentParentSelection(10);
		Selection uniformSelection = new UniformParentSelection();
		Selection survivorSelection = new ElitismSurvivorSelection();
		
		GeneticAlgorithm2 ga1 = new GeneticAlgorithm2(problem, onePointCrossover, randomSMutation, parentSelection, survivorSelection, populationSize, parentsNumber);
		GeneticAlgorithm2 ga2 = new GeneticAlgorithm2(problem, uniformCrossover, randomSMutation, parentSelection, survivorSelection, populationSize, parentsNumber);
		
		/*ArrayList<Float > arrayResults1 = new ArrayList<Float>(limit);
		ArrayList<Float > arrayResults2 = new ArrayList<Float>(limit);*/
		
		/*while(arrayResults1.size() < limit) {
			arrayResults1.add(0.0f);
			arrayResults2.add(0.0f);
		}*/
		
		
		/*for (int t = 0; t < nExperiments; t++) {
			ArrayList<Float> arrayBestFitness1 = ga1.run(limit);
			ArrayList<Float> arrayBestFitness2 = ga2.run(limit);
			for(int i = 0; i < limit; i++) {
				arrayResults1.set(i, arrayResults1.get(i) + arrayBestFitness1.get(i));
				arrayResults2.set(i, arrayResults2.get(i) + arrayBestFitness2.get(i));
			}
			//ArrayList<Float > bestFitness2 = ga2.run(limit);			
		}*/
		
		
		/*for (int i = 0; i < limit; i++ ) {
			arrayResults1.set(i,arrayResults1.get(i)/nExperiments);
			arrayResults2.set(i,arrayResults2.get(i)/nExperiments);
			
		}*/
		
		ga1.setName("Elitismo");
		ga2.setName("Aleatório");
		Experiment ex1 = new Experiment(ga1, nExperiments, limit);
		Experiment ex2 = new Experiment(ga2, nExperiments, limit);
		
		
		XYSeries series1 = ex1.run();
		
		
		XYSeries series2 = ex2.run();
		


		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		//JFreeChart graph = ChartFactory.createScatterPlot("Results", "x", "y", dataset);
		JFreeChart graph = ChartFactory.createXYLineChart("Results", "Generations", "Generation Best Fitness", dataset);
		
		graph.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		XYItemRenderer renderer = graph.getXYPlot().getRenderer();
		//XYItemRenderer renderer2 = graph.getBackgroundPaint(Color.blue);
        renderer.setSeriesPaint(0, Color.blue);
        
        
        

		ChartPanel panel = new ChartPanel(graph, true);
		panel.setPreferredSize(new java.awt.Dimension(1000, 500));
		panel.setMinimumDrawHeight(10);
		panel.setMaximumDrawHeight(2000);
		panel.setMinimumDrawWidth(20);
		panel.setMaximumDrawWidth(2000);
		
		String path = "chart.jpg";
		//String path = "/Users/Puuri/Documents/chart2.jpg"
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(
					path), graph, 500, 300);
			System.out.println("Graph successfully generated");
		} catch (IOException e) {
			System.err.println("Graph could not be generated");
		}
		
	}

	public static void testGA2() {
		String name = "Teste";
		REPRESENTATION representation = REPRESENTATION.INTEGER;
		int size = 8;
		float lowerBound = 0;
		float upperBound = 7;
		
		int populationSize = 100;
		int parentsNumber = 50;
		int limit = 1000;
		
		Comparator<Individual> comparator = new IndividualComparator(OPTIMIZATION.MINIMIZATION);
		Problem problem = new QueenProblem(name, representation, comparator, size, lowerBound, upperBound);
		Crossover crossover = new OnePointCrossover();
		//Mutation mutation = new SwapMutation(upperBound, size);
		Mutation mutation = new RandomResettingMutation(upperBound, size);
		Selection parentSelection = new TournamentParentSelection(10);
		Selection survivorSelection = new ElitismSurvivorSelection();
		
		GeneticAlgorithm2 ga2 = new GeneticAlgorithm2(problem, crossover, mutation, parentSelection, survivorSelection, populationSize, parentsNumber);
		
		ga2.run(limit);
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