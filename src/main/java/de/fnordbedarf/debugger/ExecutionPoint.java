package de.fnordbedarf.debugger;

/**
 * Created by HiekmaHe on 05.05.2017.
 *
 */
class ExecutionPoint
{
	final String fileName;
	final int lineNumber;

	ExecutionPoint(StackTraceElement stackTraceElement)
	{
		fileName = stackTraceElement.getFileName();
		lineNumber = stackTraceElement.getLineNumber();
	}
}
