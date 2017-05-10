package debugger;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

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
	void testToBeNotNull() {
		// arrange
		Object aObject = new Object();

		// act // assert
		Debugger.expect(aObject).toBeNotNull().otherwiseComplain();
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
}
