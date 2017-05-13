package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
class GivenDebuggerNull
{
	@Test
	void whenNullThenDebuggerNotNull() {
		// arrange // act
		Debugger debugger = new Debugger(null);

		// assert
		assertNotNull(debugger);
		expect(debugger).toBeNotNull();
		expect(debugger).toNotBeNull();
	}

	@Test
	void whenNullObjectThenToBeNull() {
		// arrange
		Object nullObject = null;

		// act // assert
		expect(nullObject).toBeNull().otherwiseComplain();
		expect(nullObject).toBeNull();
	}

	@Test
	void whenNullObjectToBeNullThenError() {
		// arrange
		Object nullObject = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(nullObject).toBeNull().otherwiseComplain());
	}

	@Test
	void whenNewObjectThenToNotBeNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		expect(aObject).toNotBeNull().otherwiseComplain();
	}

	@Test
	void whenNewObjectThenToBeNotNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		expect(aObject).toBeNotNull().otherwiseComplain();
	}

	@Test
	void whenNullObjectThenEqualToToNextNullObject() {
		// arrange
		Object nullObject = null;
		Object anotherNullObject = null;

		// act // assert
		expect(nullObject).toBeEqualTo(anotherNullObject).otherwiseComplain();
	}

	@Test
	void whenNullObjectToBeEqualToThenError() {
		// arrange
		Object nullObject = null;
		Object object = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(nullObject).toBeEqualTo(object).otherwiseComplain());
	}

	@Test
	void whenNewObjectToBeEqualToNullObjectThenError() {
		// arrange
		Object object = new Object();
		Object nullObject = null;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(object).toBeEqualTo(nullObject).otherwiseComplain());
	}
}
