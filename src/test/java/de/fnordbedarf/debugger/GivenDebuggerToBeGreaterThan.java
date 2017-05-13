package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;


/**
 * Created by HiekmaHe on 13.05.2017.
 */
public class GivenDebuggerToBeGreaterThan
{
	@Test
	void whenThreeThenToBeGreaterThanTwo() {
		expect(3).toBeGreaterThan(2).otherwiseComplain();
	}
}
