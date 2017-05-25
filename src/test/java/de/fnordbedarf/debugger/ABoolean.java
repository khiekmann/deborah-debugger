package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class ABoolean
{
	@Test
	void whenTrueThenTrue() {
		// arrange // act // assert
		Debugger.expect(true).toBeTrue().otherwiseComplain();
	}

	@Test
	void whenTrueToBeFalseThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(true).toBeFalse().otherwiseComplain());
		}

	@Test
	void whenFalseThenFalse() {
		// arrange // act // assert
			Debugger.expect(false).toBeFalse().otherwiseComplain();
	}

	@Test
	void whenFalseToBeTrueThenError() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseComplain());
	}
}