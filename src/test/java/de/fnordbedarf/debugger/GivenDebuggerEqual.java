package de.fnordbedarf.debugger;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import animal.*;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class GivenDebuggerEqual
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
	void whenStringThenEqualToSameString() {
		// arrange
		String message = "hi!";
		String sameMessage = message;

		// act // assert
		expect(message).toBeEqualTo(sameMessage).otherwiseComplain();
	}

	@Test
	void whenStringToBeEqualToDifferentStringThenError() {
		// arrange
		String message = "hi!";
		String notSameMessage = "hello!";

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(message).toBeEqualTo(notSameMessage).otherwiseComplain());
	}

	@Test
	void whenDogThenEqualToDog() {
		// arrange
		// act // assert
		expect(new Dog()).toBeEqualTo(new Dog(), compareAnimals).otherwiseComplain();
	}

	@Test
	void whenDogEqualToCatThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(new Dog()).toBeEqualTo(new Cat(), compareAnimals).otherwiseComplain());
	}

	@Test
	void whenOneThenToBeEqualToOne() {
		// arrange
		int one = 1;
		int oneAgain = one;

		// act //assert
		expect(one).toBeEqualTo(oneAgain).otherwiseComplain();
	}

	@Test
	void whenOneToBeEqualToTwoThenError() {
		// arrange
		int one = 1;
		int two = 2;

		// act //assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(one).toBeEqualTo(two).otherwiseComplain());
	}

	@Test
	void whenMaxThenToBeEqualMax() {
		// arrange
		Long max = Long.MAX_VALUE;
		Long maxAgain = max;

		// act //assert
		expect(max).toBeEqualTo(maxAgain).otherwiseComplain();
	}
}