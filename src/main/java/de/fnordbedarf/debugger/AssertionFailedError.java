package de.fnordbedarf.debugger;

/**
 * Created by HiekmaHe on 10.05.2017.
 *
 */
public class AssertionFailedError extends Error
{
	public AssertionFailedError(String message)
	{
		super(message);
	}

	@Override
	public String toString() {
		return super.toString() + ":" + getMessage();
	}
}
