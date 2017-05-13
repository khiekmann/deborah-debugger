package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class GivenDebuggerSleep
{
	@Test
	public void whenSleepTwoSecondsThenSleepTwoSeconds() {
		// arrange
		long twoSeconds = 2000;
		long startTime = System.currentTimeMillis();

		// act
		Debugger.sleepFor(twoSeconds);
		long duration = System.currentTimeMillis() - startTime;

		// assert
		Debugger.expect(duration).toBeGreaterThanOrEqualTo(twoSeconds).otherwiseComplain();
		Debugger.expect(duration).toBeLessThan(twoSeconds + 20 /*millis*/).otherwiseComplain();
	}
}
