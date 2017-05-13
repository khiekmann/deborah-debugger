package de.fnordbedarf.debugger;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import animal.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class EqualDebuggerTest
{
	private static CompareAnimals compareAnimals;

	@BeforeAll
	static void beforeAll() {
		ArrayList<Animal> animals = new ArrayList();
		animals.add(new Sloth());
		animals.add(new Dog());
		animals.add(new Cat());

		compareAnimals = new CompareAnimals(animals);
	}

	@Test
	void testStringObjectToBeEqualToSameStringObject() {
		// arrange
		String message = "hi!";
		String sameMessage = message;

		// act // assert
		Debugger.expect(message).toBeEqualTo(sameMessage).otherwiseComplain();
	}

	@Test
	void testStringObjectToBeEqualToNotSameStringObjectFailing() {
		// arrange
		String message = "hi!";
		String notSameMessage = "hello!";

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(message).toBeEqualTo(notSameMessage).otherwiseComplain());
	}

	@Test
	void testDogEqualToDogUsingComparator() {
		// arrange
		// act // assert
		Debugger.expect(new Dog()).toBeEqualTo(new Dog(), compareAnimals).otherwiseComplain();
	}

	@Test
	void testDogEqualToCatUsingComparatorFailing() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(new Dog()).toBeEqualTo(new Cat(), compareAnimals).otherwiseComplain());
	}

	@Test
	void testIntToBeEqualToOtherInt() {
		// arrange
		int one = 1;
		int oneAgain = one;

		// act //assert
		Debugger.expect(one).toBeEqualTo(oneAgain).otherwiseComplain();
	}

	@Test
	void testIntToBeEqualToOtherIntFailing() {
		// arrange
		int one = 1;
		int two = 2;

		// act //assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(one).toBeEqualTo(two).otherwiseComplain());
	}

	@Test
	void testLongObjectToBeEqualToOtherLongObject() {
		// arrange
		Long max = Long.MAX_VALUE;
		Long maxAgain = max;

		// act //assert
		Debugger.expect(max).toBeEqualTo(maxAgain).otherwiseComplain();
	}

	@Test
	void testLongObjectToBeEqualToOtherLongObjectFailing() {
		// arrange
		Long max = Long.MAX_VALUE;
		Long min = Long.MIN_VALUE;

		// act //assert
		Debugger.expect(max).toBeNotEqualTo(min).otherwiseComplain();
	}
}