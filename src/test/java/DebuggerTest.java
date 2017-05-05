import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import animal.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public class DebuggerTest
{

	private static CompareAnimals compareAnimals;

	@BeforeAll
	public static void beforeAll() {
		ArrayList<Animal> animals = new ArrayList();
		animals.add(new Sloth());
		animals.add(new Dog());
		animals.add(new Cat());

		compareAnimals = new CompareAnimals(animals);
	}


	@Test
	public void testConstructorWithNullObject() {
		// arrange
		// act
		Debugger debugger = new Debugger(null);

		// assert
		assertNotNull(debugger);
	}

	@Test
	public void testExpectWithNullObject() {
		// arrange
		Object object = null;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testExpectWithStringObject() {
		// arrange
		String object = "hallo";
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testExpectWithBooleanObjectTrue() {
		// arrange
		Boolean object = Boolean.TRUE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testExpectWithBooleanObjectFalse() {
		// arrange
		Boolean object = Boolean.FALSE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testExpectWithBooleanTrue() {
		// arrange
		boolean object = true;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testExpectWithBooleanFalse() {
		// arrange
		boolean object = false;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = Debugger.expect(object);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testToBeNull() {
		// arrange
		Object nullObject = null;

		// act
		boolean actual = Debugger.expect(nullObject).toBeNull();

		// assert
		assertTrue(actual);
	}

	@Test
	public void testToBeNullFailing() {
		// arrange
		Object nullObject = new Object();

		// act
		boolean actual = Debugger.expect(nullObject).toBeNull();

		// assert
		assertFalse(actual);
	}

	@Test
	public void testToNotBeNull() {
		// arrange
		Object aObject = new Object();

		// act
		boolean actual = Debugger.expect(aObject).toNotBeNull();

		// assert
		assertTrue(actual);
	}

	@Test
	public void testToBeTrue() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act
		boolean actual = Debugger.expect(aTrue).toBeTrue();

		// assert
		assertTrue(actual);
	}

	@Test
	public void testToBeTrueFailing() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act
		boolean actual = Debugger.expect(aFalse).toBeTrue();

		// assert
		assertFalse(actual);
	}

	@Test
	public void testToBeFalse() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act
		boolean actual = Debugger.expect(aFalse).toBeFalse();

		// assert
		assertTrue(actual);
	}

	@Test
	public void testToBeFalseFailing() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act
		boolean actual = Debugger.expect(aTrue).toBeFalse();

		// assert
		assertFalse(actual);
	}

	@Test
	public void testStringObjectToBeEqualToSameStringObject() {
		// arrange
		String message = "hi!";
		String sameMessage = message;

		// act
		boolean actual = Debugger.expect(message).toBeEqualTo(sameMessage);

		// assert
		assertTrue(actual);
	}

	@Test
	public void testStringObjectToBeEqualToNotSameStringObjectFailing() {
		// arrange
		String message = "hi!";
		String notSameMessage = "hello!";

		// act
		boolean actual = Debugger.expect(message).toBeEqualTo(notSameMessage);

		// assert
		assertFalse(actual);
	}

	@Test
	public void testNullObjectToBeEqualToNullObject() {
		// arrange
		Object nullObject = null;
		Object anotherNullObject = null;

		// act
		boolean actual = Debugger.expect(nullObject).toBeEqualTo(anotherNullObject);

		// assert
		assertTrue(actual);
	}

	@Test
	public void testNullObjectToBeEqualToObjectFailing() {
		// arrange
		Object nullObject = null;
		Object object = new Object();

		// act
		boolean actual = Debugger.expect(nullObject).toBeEqualTo(object);

		// assert
		assertFalse(actual);
	}

	@Test
	public void testObjectToBeEqualToNullObjectFailing() {
		// arrange
		Object object = new Object();
		Object nullObject = null;

		// act
		boolean actual = Debugger.expect(object).toBeEqualTo(nullObject);

		// assert
		assertFalse(actual);
	}

	@Test
	public void testDogEqualToDogUsingComparator() {
		// arrange
		// act
		boolean actual = Debugger.expect(new Dog()).toBeEqualTo(new Dog(), compareAnimals);

		// assert
		assertTrue(actual);
	}

	@Test
	public void testDogEqualToCatUsingComparatorFailing() {
		// arrange
		// act
		boolean actual = Debugger.expect(new Dog()).toBeEqualTo(new Cat(), compareAnimals);

		// Assert
		assertFalse(actual);
	}

	@Test
	public void testIntToBeEqualToOtherInt() {
		// arrange
		int one = 1;
		int oneAgain = one;

		// act
		boolean actual = Debugger.expect(one).toBeEqualTo(oneAgain);

		// assert
		assertTrue(actual);
	}

	@Test
	public void testIntToBeEqualToOtherIntFailing() {
		// arrange
		int one = 1;
		int two = 2;

		// act
		boolean actual = Debugger.expect(one).toBeEqualTo(two);

		// assert
		assertFalse(actual);
	}

	@Test
	public void testLongObjectToBeEqualToOtherLongObject() {
		// arrange
		Long max = Long.MAX_VALUE;
		Long maxAgain = max;

		// act
		boolean actual = Debugger.expect(max).toBeEqualTo(maxAgain);

		// assert
		assertTrue(actual);
	}

	@Test
	public void testLongObjectToBeEqualToOtherLongObjectFailing() {
	// arrange
	Long max = Long.MAX_VALUE;
	Long min = Long.MIN_VALUE;

	// act
	boolean actual = Debugger.expect(max).toBeEqualTo(min);

	// assert
	assertFalse(actual);
	}
}