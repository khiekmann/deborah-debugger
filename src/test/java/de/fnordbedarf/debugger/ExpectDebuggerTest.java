package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class ExpectDebuggerTest
{
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

}
