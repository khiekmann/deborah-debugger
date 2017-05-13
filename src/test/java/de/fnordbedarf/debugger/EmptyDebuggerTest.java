package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 10.05.2017.
 */
public class EmptyDebuggerTest
{
	@Test
	void testNullObjectToEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(null).toBeEmpty().otherwiseComplain());
	}

	@Test
	void testNullObjectToNotBeEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(null).toNotBeEmpty().otherwiseComplain());
	}

	@Test
	void testNullObjectToBeNotEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(null).toBeNotEmpty().otherwiseComplain());
	}

	@Test
	void testNewStringObjectBeEmpty() {
		// arrange // act // assert
		Debugger.expect(new String()).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testNewStringToNotBeEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(new String()).toNotBeEmpty().otherwiseComplain()
		);
	}

	@Test
	void testNewStringToBeEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(new String()).toBeNotEmpty().otherwiseComplain()
		);
	}

	@Test
	void testStringToBeNotEmpty() {
		// arrange // act // assert
		Debugger.expect("hello").toBeNotEmpty().otherwiseComplain();
	}

	@Test
	void testStringToNotBeEmpty() {
		// arrange // act // assert
		Debugger.expect("hello").toNotBeEmpty().otherwiseComplain();
	}

	@Test
	void testStringToBeEmptyExpectError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
				Debugger.expect("hello").toBeEmpty().otherwiseComplain()
		);
	}
}