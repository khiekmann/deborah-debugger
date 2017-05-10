package debugger;

import org.junit.jupiter.api.Test;

import static debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by HiekmaHe on 05.05.2017.
 */
class OtherwiseDebuggerTest
{
	@Test
	void testMurmur() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseMurmur());
	}

	@Test
	void testMurmurExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseMurmur();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testMurmurExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseMurmur();
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage()).toBeEqualTo("assertion error.").otherwiseComplain();
	}

	@Test
	void testComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	void testComplainExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseComplain();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testComplainExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseComplain();
		} catch (AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(-882627246).otherwiseComplain();
	}

	@Test
	void testAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}

	@Test
	void testAnnounceExpectMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseAnnounce("huh");

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testAnnounceExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseAnnounce("ignore me");
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(443997862).otherwiseComplain();
	}
	
	@Test
	void testOtherwiseReturnErrorExpectError() {
		// arrange // act
		AssertionFailedError error;
		error = expect(false).toBeTrue().otherwiseReturnError();
		// assert
		expect(error).toBeNotNull().otherwiseComplain();
		expect(error.getMessage()).toBeEqualTo("assertion error.").otherwiseComplain();
	}
}