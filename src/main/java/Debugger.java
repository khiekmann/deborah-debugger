/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public class Debugger
{
	private final static String N = System.getProperty("line.separator");
	private final Object thisObject;

	private boolean failureAsserted;
	private Object otherObject;
	private RelatesAs thisIs;

	public static String show(Object object) {
		StackTraceElement lastCall = Thread.currentThread().getStackTrace()[2];
		String message = createMessage(lastCall, object);
		return printToConsole(message);
	}

	private static String createMessage(StackTraceElement lastCall, Object object)
	{
		return String.format(
				".(%s:%d): %s",
				lastCall.getFileName(), lastCall.getLineNumber(), String.valueOf(object)
		);
	}

	private static String printToConsole(String message)
	{
		System.out.println(message);
		return message;
	}

	public static void exit(Object object)
	{
		show(object);
		exit(object.hashCode());
	}

	public static void exit(Exception exception)
	{
		show(exception.getMessage());
		exit(exception.hashCode());
	}


	public static void exit()
	{
		String message = "Debugger shuts down.";
		show(message);
		System.exit(message.hashCode());
	}

	public static void exit(int exitCode)
	{
		System.exit(exitCode);
	}

	public static void sleep(long millis)
	{
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static Debugger expect(Object object)
	{
		return new Debugger(object);
	}

	public Debugger(Object object)
	{
		thisObject = object;
		otherObject = object;
		failureAsserted = false;
		thisIs = RelatesAs.notSet;
	}

	@Override
	public int hashCode() {
		return String.valueOf(thisObject).hashCode();
	}

	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;
		if (isADebugger(object)) {
			isEqual = sameHashCodeAs(object);
		}
		return isEqual;
	}

	private boolean isADebugger(Object object)
	{
		return (object instanceof Debugger);
	}

	private boolean sameHashCodeAs(Object object)
	{
		return hashCode() == object.hashCode();
	}

	private void otherObject(Object object)
	{
		otherObject = object;
	}

	private void thisRelatesToOtherAs(RelatesAs thisIs)
	{
		this.thisIs = thisIs;
	}

	// Methods comparing thisObject with otherObject

	public boolean toBeNull()
	{
		thisRelatesToOtherAs(RelatesAs.null_);
		return thisObject == null;
	}

	public boolean toNotBeNull()
	{
		thisRelatesToOtherAs(RelatesAs.notNull);
		return ! toBeNull();
	}

	public boolean toBeTrue()
	{
		thisRelatesToOtherAs(RelatesAs.true_);
		return thisObject == Boolean.TRUE;
	}

	public boolean toBeFalse()
	{
		thisRelatesToOtherAs(RelatesAs.false_);
		return ! toBeTrue();
	}

	public boolean toBeEqualTo(Object otherObject)
	{
		otherObject(otherObject);
		thisRelatesToOtherAs(RelatesAs.equal);
		return thisObjectEqualsToOtherObject();
	}

	private boolean thisObjectEqualsToOtherObject()
	{
		boolean bothEqual;
		try {
			bothEqual = thisObject.equals(otherObject);
		} catch (NullPointerException e) {
			bothEqual = (thisObject == null) && (otherObject == null);
		}
		return bothEqual;
	}

	public boolean toBeGreaterThan(Object otherObject)
	{
		this.otherObject = otherObject;
		return false;
	}
}