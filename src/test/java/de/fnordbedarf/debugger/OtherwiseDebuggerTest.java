package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

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
						Debugger.expect(false).toBeTrue().otherwiseMurmur());
	}

	@Test
	void testMurmurExpectMessageToBeEmpty() {
		// arrange // act
		String message = Debugger.expect(true).toBeTrue().otherwiseMurmur();

		// assert
		Debugger.expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testMurmurExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			Debugger.expect(false).toBeTrue().otherwiseMurmur();
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		Debugger.expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		Debugger.expect(assertionFailedError.getMessage()).toBeEqualTo("assertion error.").otherwiseComplain();
	}

	@Test
	void testComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	void testComplainExpectMessageToBeEmpty() {
		// arrange // act
		String message = Debugger.expect(true).toBeTrue().otherwiseComplain();

		// assert
		Debugger.expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testComplainExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			Debugger.expect(false).toBeTrue().otherwiseComplain();
		} catch (AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		Debugger.expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		Debugger.expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(-882627246).otherwiseComplain();
	}

	@Test
	void testAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						Debugger.expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}

	@Test
	void testAnnounceExpectMessageToBeEmpty() {
		// arrange // act
		String message = Debugger.expect(true).toBeTrue().otherwiseAnnounce("huh");

		// assert
		Debugger.expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void testAnnounceExpectMessageToBeNotEmpty() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			Debugger.expect(false).toBeTrue().otherwiseAnnounce("ignore me");
		} catch ( AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		Debugger.expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		Debugger.expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(443997862).otherwiseComplain();
	}
}