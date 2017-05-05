import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import animal.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
class DebuggerTest
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
	void testConstructorWithNullObject() {
		// arrange
		// act
		Debugger debugger = new Debugger(null);

		// assert
		assertNotNull(debugger);
	}

	@Test
	void testExpectWithNullObject() {
		// arrange
		Object object = null;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testExpectWithStringObject() {
		// arrange
		String object = "hallo";
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testExpectWithBooleanObjectTrue() {
		// arrange
		Boolean object = Boolean.TRUE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testExpectWithBooleanObjectFalse() {
		// arrange
		Boolean object = Boolean.FALSE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testExpectWithBooleanTrue() {
		// arrange
		boolean object = true;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testExpectWithBooleanFalse() {
		// arrange
		boolean object = false;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void testToBeNull() {
		// arrange
		Object nullObject = null;

		// act // assert
		Debugger.expect(nullObject).toBeNull().otherwiseComplain();
	}

	@Test
	void testToBeNullFailing() {
		// arrange
		Object nullObject = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(nullObject).toBeNull().otherwiseComplain());
	}

	@Test
	void testToNotBeNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		Debugger.expect(aObject).toNotBeNull().otherwiseComplain();
	}

	@Test
	void testToBeTrue() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act // assert
		Debugger.expect(aTrue).toBeTrue().otherwiseComplain();
	}

	@Test
	void testToBeTrueFailing() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(aFalse).toBeTrue().otherwiseComplain());
	}

	@Test
	void testToBeFalse() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act // assert
		Debugger.expect(aFalse).toBeFalse().otherwiseComplain();
	}

	@Test
	void testToBeFalseFailing() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(aTrue).toBeFalse().otherwiseComplain());
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
	void testNullObjectToBeEqualToNullObject() {
		// arrange
		Object nullObject = null;
		Object anotherNullObject = null;

		// act // assert
		Debugger.expect(nullObject).toBeEqualTo(anotherNullObject).otherwiseComplain();
	}

	@Test
	void testNullObjectToBeEqualToObjectFailing() {
		// arrange
		Object nullObject = null;
		Object object = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(nullObject).toBeEqualTo(object).otherwiseComplain());
	}

	@Test
	void testObjectToBeEqualToNullObjectFailing() {
		// arrange
		Object object = new Object();
		Object nullObject = null;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(object).toBeEqualTo(nullObject).otherwiseComplain());
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