package debugger;

import org.junit.jupiter.api.Test;

import static debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class NullDebuggerTest
{
	@Test
	void testConstructorWithNullObject() {
		// arrange // act
		Debugger debugger = new Debugger(null);

		// assert
		assertNotNull(debugger);
	}

	@Test
	void testToBeNull() {
		// arrange
		Object nullObject = null;

		// act // assert
		expect(nullObject).toBeNull().otherwiseComplain();
	}

	@Test
	void testToBeNullFailing() {
		// arrange
		Object nullObject = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(nullObject).toBeNull().otherwiseComplain());
	}

	@Test
	void testToNotBeNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		expect(aObject).toNotBeNull().otherwiseComplain();
	}

	@Test
	void testToBeNotNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		expect(aObject).toBeNotNull().otherwiseComplain();
	}

	@Test
	void testNullObjectToBeEqualToNullObject() {
		// arrange
		Object nullObject = null;
		Object anotherNullObject = null;

		// act // assert
		expect(nullObject).toBeEqualTo(anotherNullObject).otherwiseComplain();
	}

	@Test
	void testNullObjectToBeEqualToObjectFailing() {
		// arrange
		Object nullObject = null;
		Object object = new Object();

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(nullObject).toBeEqualTo(object).otherwiseComplain());
	}

	@Test
	void testObjectToBeEqualToNullObjectFailing() {
		// arrange
		Object object = new Object();
		Object nullObject = null;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(object).toBeEqualTo(nullObject).otherwiseComplain());
	}
}
