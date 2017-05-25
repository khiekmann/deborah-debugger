package de.fnordbedarf.debugger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by HiekmaHe on 05.05.2017.
 */
public class Print
{
	private final static ArrayList<String> invalidClassNames =
			new ArrayList(Arrays.asList(new String[]{
					"java.lang.Thread",
					"de.fnordbedarf.debugger.Print",
					"de.fnordbedarf.debugger.Debugger"
			}));
	private final StackTraceElement[] elements = Thread.currentThread().getStackTrace();

	private final Object object;

	private ExecutionPoint executionPointToPrepend;
	private int index = 0;

	static Print print(Object object) {
		return new Print(object);
	}

	private Print(Object object)
	{
		this.object = object;
		findExecutionPointToPrepend();
	}

	private void findExecutionPointToPrepend() {
		while(validExecutionPointNotYetFound()) {
			ifNextExecutionPointIsValidThenSetIt();
		}
	}

	private boolean validExecutionPointNotYetFound() {
		return executionPointToPrepend == null;
	}

	private void ifNextExecutionPointIsValidThenSetIt()
	{
		if(classNameOfNextExecutionPointIsValid()) {
			setExecutionPointToPrepend();
		}
	}

	private boolean classNameOfNextExecutionPointIsValid()
	{
		StackTraceElement nextElement = nextElement();
		String className = nextElement.getClassName();
		return isValid(className);
	}

	private StackTraceElement nextElement()
	{
		return elements[++index];
	}

	private boolean isValid(String className) {
		return ! isInvalid(className);
	}

	private boolean isInvalid(String className) {
		return invalidClassNames.contains(className);
	}

	private void setExecutionPointToPrepend()
	{
		executionPointToPrepend = new ExecutionPoint(element());
	}

	private StackTraceElement element()
	{
		return elements[index];
	}

	String toConsole()
	{
		String message = createMessage();
		System.out.println(message);
		return message;
	}

	private String createMessage()
	{
		return String.format(".(%s:%d): %s", fileName(), lineNumber(), messageOfObject());
	}

    private Object messageOfObject() {
	    String message = String.valueOf(object);
	    if (objectIsArray()) {
            message = arrayedValueOfObject();
        }
        return message;
    }

    private boolean objectIsArray() {
        return object.getClass().isArray();
    }

    private String arrayedValueOfObject() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(object.getClass().getCanonicalName());
	    builder.append(" [ ");
	    for ( int index = 0; index < Array.getLength(object); index++) {
	         builder
                     .append(Array.get(object, index))
                     .append(", ");
        }
        return builder.append("]").toString();
    }

    private String fileName()
	{
		return executionPointToPrepend.fileName;
	}

	private int lineNumber()
	{
		return executionPointToPrepend.lineNumber;
	}
}