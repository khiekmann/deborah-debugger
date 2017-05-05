package debugger;

import org.junit.jupiter.api.Test;

import debugger.Debugger;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class SleepDebuggerTest
{
	@Test
	public void test2SecondSleep() {
		// arrange
		int twoSeconds = 2000;
		long startTime = System.currentTimeMillis();

		// act
		Debugger.sleepFor(twoSeconds);
		long duration = System.currentTimeMillis() - startTime;

		// assert
		Debugger.show("=======" + duration);
		Debugger.expect(duration).toBeGreaterThan(twoSeconds).otherwiseComplain();
		Debugger.expect(duration).toBeLessThan(twoSeconds + 20 /*millis*/).otherwiseComplain();
	}
}
