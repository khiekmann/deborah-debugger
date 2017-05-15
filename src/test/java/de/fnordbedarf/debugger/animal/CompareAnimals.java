package de.fnordbedarf.debugger.animal;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * Created by HiekmaHe on 04.05.2017.
 */
public class CompareAnimals implements Comparator<Animal>
{
	private final ArrayList<Animal> animals;

	public CompareAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public int compare(Animal animal, Animal otherAnimal)
	{
		int indexOfAnimal = indexOf(animal);
		int indexOfOtherAnimal = indexOf(otherAnimal);
		return indexOfAnimal - indexOfOtherAnimal;
	}

	private int indexOf(Animal animal)
	{
		int index = positionOf(animal);
		evaluateIndex(index, animal);
		return index;
	}

	private int positionOf(Animal animal)
	{
		int index = 0;
		for (; index < animals.size(); index++) {
			if (equalCanonicalClassName(animal, animals.get(index))){
				break;
			}
		}
		return index;
	}

	private boolean equalCanonicalClassName(Animal thisAnimalOrNull, Animal otherAnimal)
	{
		return equalClass(thisAnimalOrNull, otherAnimal);
	}

	private void evaluateIndex(int index, Animal animal)
	{
		if (index == -1) {
			throw new RuntimeException(animal + " not found!");
		}
	}

	private boolean equalClass(Animal thisAnimal, Animal otherAnimal)
	{
		return thisAnimal.getClass().getCanonicalName().equals(otherAnimal.getClass().getCanonicalName());
	}
}
