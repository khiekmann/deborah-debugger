package de.fnordbedarf.debugger;

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
		String expected = ".(Print.java:18): hello world!";
		String showMe = "hello world!";

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void integerThenExpectIt() {
		// arrange
		String expected = ".(Print.java:18): 2147483647";
		Integer showMe = Integer.MAX_VALUE;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void intThenExpectIt() {
		// arrange
		String expected = ".(Print.java:18): -1";
		int showMe = -1;

		// act
		String actual = Debugger.show(showMe);

		// assert
		assertEquals(expected, actual);
	}
}