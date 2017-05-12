package debugger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static debugger.Debugger.exit;


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
		exit();
	}

	@Disabled
	@Test
	void testExitWithException() {
		exit(new Exception("Exception"));
	}

	@Disabled
	@Test
	void testExitWithObject() {
		exit(new Object());
	}

	@Disabled
	@Test
	void testExitWithExitCode() {
		exit(-1337);
	}
}