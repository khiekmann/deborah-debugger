package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
class Expect
{
	@Test
	void whenNullThenToBeEqualToNull() {
		// arrange
		Object object = null;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenStringThenToBeEqualToString() {
		// arrange
		String object = "hallo";
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenTrueObjectThenToBeEqualToTrueObject() {
		// arrange
		Boolean object = Boolean.TRUE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenFalseObjectThenToBeEqualFalseObject() {
		// arrange
		Boolean object = Boolean.FALSE;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenTrueThenToBeEqualTrue() {
		// arrange
		boolean object = true;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenFalseThenToBeEqualFalse() {
		// arrange
		boolean object = false;
		Debugger expected = new Debugger(object);

		// act
		Debugger actual = expect(object);

		// assert
		assertEquals(expected, actual);
	}
}