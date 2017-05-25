package de.fnordbedarf.debugger.givendebugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;


/**
 * Created by HiekmaHe on 13.05.2017.
 *
 */
class ToBeGreaterThan
{
	@Test
	void whenThreeThenToBeGreaterThanTwo() {
		expect(3).toBeGreaterThan(2).otherwiseComplain();
	}

	@Test
	void whenTenToBeGreaterThanThree() {
		expect(10).toBeGreaterThan(3).otherwiseComplain();
	}
}
