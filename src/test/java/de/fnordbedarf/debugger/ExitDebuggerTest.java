package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.exit;


/**
 * Created by HiekmaHe on 05.05.2017.
 *
 *
 *
 */
class ExitDebuggerTest
{
	@Disabled
	@Test
	void testExit() {
		Debugger.exit();
	}

	@Disabled
	@Test
	void testExitWithException() {
		Debugger.exit(new Exception("Exception"));
	}

	@Disabled
	@Test
	void testExitWithObject() {
		Debugger.exit(new Object());
	}

	@Disabled
	@Test
	void testExitWithExitCode() {
		Debugger.exit(-1337);
	}
}