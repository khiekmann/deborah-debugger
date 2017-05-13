package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class BooleanDebuggerTest
{
	@Test
	void testToBeTrue() {
		// arrange // act // assert
		Debugger.expect(true).toBeTrue().otherwiseComplain();
	}

	@Test
	void testToBeTrueFailing() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	void testToBeFalse() {
		// arrange // act // assert
			Debugger.expect(false).toBeFalse().otherwiseComplain();
	}

	@Test
	void testToBeFalseFailing() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(true).toBeFalse().otherwiseComplain());
	}
}