package de.fnordbedarf.debugger.givendebugger;

import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.show;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by HiekmaHe on 04.05.2017.
 */
class Show
{
	@Test
	void whenMessageThenShowClickableTextAndText() {
		// arrange
		String expected = ".(Print.java:18): hello world!";
		String showMe = "hello world!";

		// act
		String actual = show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void whenMessageThenShowClickableTextAndText2() {
		// arrange
		String expected = ".(Print.java:18): 2147483647";
		Integer showMe = Integer.MAX_VALUE;

		// act
		String actual = show(showMe);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	void whenMessageThenShowClickableTextAndText3() {
		// arrange
		String expected = ".(Print.java:18): -1";
		int showMe = -1;

		// act
		String actual = show(showMe);

		// assert
		assertEquals(expected, actual);
	}
}