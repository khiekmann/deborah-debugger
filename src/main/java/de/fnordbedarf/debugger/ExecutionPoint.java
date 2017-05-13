package de.fnordbedarf.debugger;

/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class ExecutionPoint
{
	public final String fileName;
	public final int lineNumber;

	public ExecutionPoint(StackTraceElement stackTraceElement)
	{
		fileName = stackTraceElement.getFileName();
		lineNumber = stackTraceElement.getLineNumber();
	}
}
