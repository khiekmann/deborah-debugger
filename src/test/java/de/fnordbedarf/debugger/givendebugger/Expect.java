package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.Debugger;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 05.05.2017.
 *
 */
class Expect
{
	@Test
	void whenNullThenToBeEqualToNull() {
		// arrange
		Debugger expected = new Debugger(null);

		// act
		Debugger actual = expect(null);

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
		Debugger expected = new Debugger(Boolean.TRUE);

		// act
		Debugger actual = expect(Boolean.TRUE);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenFalseObjectThenToBeEqualFalseObject() {
		// arrange
		Debugger expected = new Debugger(Boolean.FALSE);

		// act
		Debugger actual = expect(Boolean.FALSE);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenTrueThenToBeEqualTrue() {
		// arrange
		Debugger expected = new Debugger(true);

		// act
		Debugger actual = expect(true);

		// assert
		assertEquals(expected, actual);
		expect(expected).toBeEqualTo(actual).otherwiseComplain();
		expect(actual).toBeEqualTo(expected).otherwiseComplain();
	}

	@Test
	void whenFalseThenToBeEqualFalse() {
		// arrange
		Debugger expected = new Debugger(false);

		// act
		Debugger actual = expect(false);

		// assert
		assertEquals(expected, actual);
	}
}