package debugger;

import debugger.Debugger;


/**
 * Created by HiekmaHe on 05.05.2017.
 *
 *
 *
 */
class ExitDebuggerTest
{
	//	@Test
	void testExit() {
		Debugger.exit();
	}

	//	@Test
	void testExitWithException() {
		Debugger.exit(new Exception("Exception"));
	}

	//	@Test
	void testExitWithObject() {
		Debugger.exit(new Object());
	}

	// @Test
	void testExitWithExitCode() {
		Debugger.exit(-1337);
	}
}