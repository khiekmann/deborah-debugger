package debugger;

import org.junit.jupiter.api.Test;

import static debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class BooleanDebuggerTest
{
	@Test
	void testToBeTrue() {
		// arrange // act // assert
		expect(true).toBeTrue().otherwiseComplain();
	}

	@Test
	void testToBeTrueFailing() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	void testToBeFalse() {
		// arrange // act // assert
			expect(false).toBeFalse().otherwiseComplain();
	}

	@Test
	void testToBeFalseFailing() {
		// arrange // act // assert
		assertThrows(
				AssertionFailedError.class, () ->
						expect(true).toBeFalse().otherwiseComplain());
	}
}