package debugger;

import org.junit.jupiter.api.Test;

import static debugger.Debugger.expect;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class SleepDebuggerTest
{
	@Test
	public void test2SecondSleep() {
		// arrange
		long twoSeconds = 2000;
		long startTime = System.currentTimeMillis();

		// act
		Debugger.sleepFor(twoSeconds);
		long duration = System.currentTimeMillis() - startTime;

		// assert
		expect(duration).toBeGreaterThanOrEqualTo(twoSeconds).otherwiseComplain();
		expect(duration).toBeLessThan(twoSeconds + 20 /*millis*/).otherwiseComplain();
	}
}
