package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.AssertionFailedError;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 10.05.2017.
 *
 */
class Empty
{
	private static final String newString = String.valueOf("");

	@Test
	void whenNullObjectToBeEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toBeEmpty().otherwiseComplain());
	}

	@Test
	void whenNullObjectToNotBeEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toNotBeEmpty().otherwiseComplain());
	}

	@Test
	void whenNullObjectToBeNotEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toBeNotEmpty().otherwiseComplain());
	}

	@Test
	void whenNewStringThenToBeEmpty() {
		expect(new String()).toBeEmpty().otherwiseComplain();
	}

	@Test
	void whenNewStringToNotBeEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(newString).toNotBeEmpty().otherwiseComplain()
		);
	}

	@Test
	void whenNewStringToBeNotEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(newString).toBeNotEmpty().otherwiseComplain()
		);
	}

	@Test
	void whenStringThenToBeNotEmpty() {
		expect("hello").toBeNotEmpty().otherwiseComplain();
	}

	@Test
	void whenStringThenToNotBeEmpty() {
		expect("hello").toNotBeEmpty().otherwiseComplain();
	}

	@Test
	void whenStringToBeEmptyThenError() {
		assertThrows(
				AssertionFailedError.class, () ->
				expect("hello").toBeEmpty().otherwiseComplain()
		);
	}
}