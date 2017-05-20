package de.fnordbedarf.debugger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/**
 * Created by HiekmaHe on 05.05.2017.
 *
 *
 *
 */
class Exit
{
	@Disabled
	@Test
	void whenExitThenExit() {
		Debugger.exit();
	}

	@Disabled
	@Test
	void whenExitThenExitWithException() {
		Debugger.exit(new Exception("Exception"));
	}

	@Disabled
	@Test
	void whenExitThenExitWithObject() {
		Debugger.exit(new Object());
	}

	@Disabled
	@Test
	void whenExitThenExitWithNumber() {
		Debugger.exit(-1337);
	}
}