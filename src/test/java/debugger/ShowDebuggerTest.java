package debugger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 04.05.2017.
 */
public class ShowDebuggerTest
{
	@Test
	public void stringThenExpectIt() {
		// arrange
		String expected = ".(ShowDebuggerTest.java:20): hello world!";
		String showMe = "hello world!";

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void integerThenExpectIt() {
		// arrange
		String expected = ".(ShowDebuggerTest.java:33): 2147483647";
		Integer showMe = Integer.MAX_VALUE;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void intThenExpectIt() {
		// arrange
		String expected = ".(ShowDebuggerTest.java:46): -1";
		int showMe = -1;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}
}