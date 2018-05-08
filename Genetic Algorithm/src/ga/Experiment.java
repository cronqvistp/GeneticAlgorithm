package ga;

import java.util.ArrayList;

import org.jfree.data.xy.XYSeries;


public class Experiment {
	
	private int experimentsNumber;
	private GeneticAlgorithm2 algorithm;
	private int limit;

	public Experiment(GeneticAlgorithm2 algorithm, int experimentsNumber, int limit) {
		this.experimentsNumber = experimentsNumber;
		this.algorithm = algorithm;
		this.limit = limit;
	}
	
	public XYSeries run() {
		
		ArrayList<ArrayList<Float>> results = new ArrayList<ArrayList<Float>>();
		
		for(int i = 0; i < this.experimentsNumber; i++) {
			
			results.add(this.algorithm.run(this.limit));	
			
		}
		
		
		XYSeries series = new XYSeries(this.algorithm.getName());
		
		for(int i = 0; i < this.limit; i++) {
			float sum = 0;
			for(int j = 0; j < results.size(); j++) {
				sum += results.get(j).get(i);
				
			}
			
			sum = sum/this.experimentsNumber;
			
			series.add(i, sum);
		}
		
		return series;
		
	}
	
	

}
