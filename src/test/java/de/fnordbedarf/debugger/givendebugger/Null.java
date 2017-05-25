package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.AssertionFailedError;
import de.fnordbedarf.debugger.Debugger;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by HiekmaHe on 05.05.2017.
 *
 */
class Null
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
		expect(null).toBeNull().otherwiseComplain();
		expect(null).toBeNull();
	}

	@Test
	void whenNullObjectToBeNullThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(new Object()).toBeNull().otherwiseComplain());
	}

	@Test
	void whenNewObjectThenToNotBeNull() {
		expect(new Object()).toNotBeNull().otherwiseComplain();
	}

	@Test
	void whenNewObjectThenToBeNotNull() {
		expect(new Object()).toBeNotNull().otherwiseComplain();
	}

	@Test
	void whenNullObjectThenEqualToNextNullObject() {
		// arrange
		Object nullObject = null;
		Object anotherNullObject = null;

		// act // assert
		expect(nullObject).toBeEqualTo(anotherNullObject).otherwiseComplain();
	}

    @Test
    void whenNullThenNullFormatException() {
        assertThrows(
                NumberFormatException.class, () ->
                        expect(null).toBeEqualTo(null).otherwiseComplain());
    }

	@Test
	void whenNullObjectToBeEqualToThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toBeEqualTo(new Object()).otherwiseComplain());
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

    @Test
    void whenNewObjectToBeEqualToNullObjectThenNumberFormat() {
        assertThrows(
                NumberFormatException.class, () ->
                        expect(new Object()).toBeEqualTo(null).otherwiseComplain());
    }
}