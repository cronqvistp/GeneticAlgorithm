package ga.selection;

import java.util.ArrayList;
import java.util.Comparator;

import ga.Individual;

public interface SelectionInterface {
	
	public ArrayList<Individual> selection(ArrayList<Individual> population, int size, Comparator<Individual> comparator);

}
