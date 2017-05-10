package debugger;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class OtherwiseDebuggerTest
{
	@Test
	public void testMurmur() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseMurmur());
	}

	@Test
	public void testMurmurExpectSystemOutPrintln() {
		// arrange
		String message;

		// act
		try {
			message = expect(false).toBeTrue().otherwiseMurmur();
		} catch (Error e) {
			message = "";
		}

		// assert
		expect(message).toBeNotEmpty().otherwiseComplain();
	}

	@Test
	public void testComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	public void testAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}
}