import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 04.05.2017.
 */
public class GivenDebuggerWhenShow
{
	@Test
	public void stringThenExpectIt() {
		// arrange
		String expected = ".(GivenDebugger.java:18): hello world!";
		String showMe = "hello world!";

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void integerThenExpectIt() {
		// arrange
		String expected = ".(GivenDebugger.java:31): 2147483647";
		Integer showMe = Integer.MAX_VALUE;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void intThenExpectIt() {
		// arrange
		String expected = ".(GivenDebugger.java:44): -1";
		int showMe = -1;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}
}