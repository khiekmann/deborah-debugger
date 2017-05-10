package debugger;

import org.junit.jupiter.api.Test;

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
	public void testMurmurExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseMurmur();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	public void testMurmurExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseMurmur();
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage()).toBeNotEmpty().otherwiseComplain();
		expect(assertionFailedError.getMessage()).toBeEqualTo("assertion error.").otherwiseComplain();
	}

	@Test
	public void testComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	public void testComplainExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseComplain();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	public void testComplainExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseComplain();
		} catch (AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage()).toBeNotEmpty().otherwiseComplain();
		expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(-882627246).otherwiseComplain();
	}

	@Test
	public void testAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}

	@Test
	public void testAnnounceExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseAnnounce("huh");

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	public void testAnnounceExpectMessageToBeNotEmpty() {
		// arrange // act
		String message = "";
		AssertionFailedError assertionFailedError = null;
		try {
			message = expect(false).toBeTrue().otherwiseAnnounce("ignore me");
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage()).toBeNotEmpty().otherwiseComplain();
		expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(443997862).otherwiseComplain();
	}
}