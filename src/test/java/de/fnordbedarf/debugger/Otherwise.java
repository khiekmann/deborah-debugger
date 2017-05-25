package de.fnordbedarf.debugger;

import java.util.logging.Level;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by HiekmaHe on 05.05.2017.
 */
class Otherwise
{
	@Test
	void whenMurmurThenMurmur() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseMurmur());
	}

	@Test
	void whenMurmurThenMessageEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseMurmur();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void whenMurmurThenMessageToBeNotEmpty() {
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
	void whenComplainThenComplain() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseComplain());
	}

	@Test
	void whenTrueThenMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseComplain();

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void whenComplainThenComplained() {
		// arrange // act
		AssertionFailedError assertionFailedError = null;
		try {
			expect(false).toBeTrue().otherwiseComplain();
		} catch (AssertionFailedError e) {
			assertionFailedError = e;
		}

		// assert
		expect(assertionFailedError).toBeNotNull().otherwiseComplain();
		expect(assertionFailedError.getMessage().hashCode()).toBeEqualTo(1947453602).otherwiseComplain();
	}

	@Test
	void whenAnnounceThenAnnounce() {
		assertThrows(
				AssertionFailedError.class, () ->
						expect(false).toBeTrue().otherwiseAnnounce("hello"));
	}

	@Test
	void whenNotAnnounceThenMessageToBeEmpty() {
		// arrange // act
		String message = expect(true).toBeTrue().otherwiseAnnounce("huh");

		// assert
		expect(message).toBeEmpty().otherwiseComplain();
	}

	@Test
	void whenAnnounceThenMessageToBeEmpty() {
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
	void whenLogThenLog() {
		expect(true).toBeFalse().otherwiseLog();
	}

	@Test
	void whenLogAsSevereThenLogAsSevere() {
		Level severe = Level.SEVERE;
		expect(true).toBeFalse().otherwiseLogAs(severe);
	}
}