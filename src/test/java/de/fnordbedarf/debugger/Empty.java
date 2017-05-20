package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 10.05.2017.
 */
public class Empty
{
	@Test
	void whenNullObjectToBeEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toBeEmpty().otherwiseComplain());
	}

	@Test
	void whenNullObjectToNotBeEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toNotBeEmpty().otherwiseComplain());
	}

	@Test
	void whenNullObjectToBeNotEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(null).toBeNotEmpty().otherwiseComplain());
	}

	@Test
	void whenNewStringThenToBeEmpty() {
		// arrange // act // assert
		expect(new String()).toBeEmpty().otherwiseComplain();
	}

	@Test
	void whenNewStringToNotBeEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(new String()).toNotBeEmpty().otherwiseComplain()
		);
	}

	@Test
	void whenNewStringToBeNotEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(new String()).toBeNotEmpty().otherwiseComplain()
		);
	}

	@Test
	void whenStringThenToBeNotEmpty() {
		// arrange // act // assert
		expect("hello").toBeNotEmpty().otherwiseComplain();
	}

	@Test
	void whenStringThenToNotBeEmpty() {
		// arrange // act // assert
		expect("hello").toNotBeEmpty().otherwiseComplain();
	}

	@Test
	void whenStringToBeEmptyThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
				expect("hello").toBeEmpty().otherwiseComplain()
		);
	}
}