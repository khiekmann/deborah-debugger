package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;


/**
 * Created by HiekmaHe on 13.05.2017.
 */
public class NotEqualDebuggerTest
{
	@Test
	void testLongObjectToBeEqualToOtherLongObjectFailing() {
		// arrange
		Long max = Long.MAX_VALUE;
		Long min = Long.MIN_VALUE;

		// act //assert
		expect(max).toBeNotEqualTo(min).otherwiseComplain();
	}

	@Test
	void testObjectToBeEqualToOtherLongObjectFailing() {
		// arrange
		Object object = new Object();
		Object otherObject = new Object();

		// act //assert
		expect(object).toBeNotEqualTo(otherObject).otherwiseComplain();
	}

	@Test
	void testObjectToBeEqualToOtherLongObjectFailing2() {
		// arrange
		Object object = new Object();
		Object otherObject = new Object();

		// act //assert
		expect(object).toNotBeEqualTo(otherObject).otherwiseComplain();
	}
}
