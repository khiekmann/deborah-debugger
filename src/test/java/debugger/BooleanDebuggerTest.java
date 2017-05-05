package debugger;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import debugger.Debugger;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class BooleanDebuggerTest
{
	@Test
	void testToBeTrue() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act // assert
		Debugger.expect(aTrue).toBeTrue().otherwiseComplain();
	}

	@Test
	void testToBeTrueFailing() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(aFalse).toBeTrue().otherwiseComplain());
	}

	@Test
	void testToBeFalse() {
		// arrange
		Boolean aFalse = Boolean.FALSE;

		// act // assert
		Debugger.expect(aFalse).toBeFalse().otherwiseComplain();
	}

	@Test
	void testToBeFalseFailing() {
		// arrange
		Boolean aTrue = Boolean.TRUE;

		// act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(aTrue).toBeFalse().otherwiseComplain());
	}

}
