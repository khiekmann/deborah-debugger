import java.math.BigDecimal;
import java.util.Comparator;


/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public class Debugger
{
	private final static String N = System.getProperty("line.separator");
	private final Object this_;

	private boolean failureAsserted;
	private Object other;
	private As thisIs;

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
		this_ = object;
		other = object;
		failureAsserted = false;
		thisIs = As.notSet;
	}

	@Override
	public int hashCode() {
		return String.valueOf(this_).hashCode();
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

	private void other(Object object)
	{
		other = object;
	}

	private void thisRelatesToOther(As thisIs)
	{
		this.thisIs = thisIs;
	}

	// Methods comparing thisObject with otherObject

	public boolean toBeNull()
	{
		thisRelatesToOther(As.null_);
		return this_ == null;
	}

	public boolean toNotBeNull()
	{
		thisRelatesToOther(As.notNull);
		return ! toBeNull();
	}

	public boolean toBeTrue()
	{
		thisRelatesToOther(As.true_);
		return this_ == Boolean.TRUE;
	}

	public boolean toBeFalse()
	{
		thisRelatesToOther(As.false_);
		return ! toBeTrue();
	}

	public boolean toBeEqualTo(Object object)
	{
		other(object);
		thisRelatesToOther(As.equal);
		return thisObjectEqualsToOtherObject();
	}

	private boolean thisObjectEqualsToOtherObject()
	{
		boolean bothEqual;
		try {
			bothEqual = this_.equals(other);
		} catch (NullPointerException e) {
			bothEqual = (this_ == null) && (other == null);
		}
		return bothEqual;
	}

	public boolean toBeEqualTo(Object object, Comparator comparator) {
		other(object);
		thisRelatesToOther(As.equal);
		return comparator.compare(this_, other) == 0;
	}

	public boolean toBeEqualTo(Number number)
	{
		other(number);
		thisRelatesToOther(As.equal);
		return (compareAsNumber(this_, other) == 0);
	}

	public int compareAsNumber(Object first, Object second) {
		BigDecimal firstNumber = new BigDecimal(first.toString());
		BigDecimal secondNumber = new BigDecimal(second.toString());
		return firstNumber.compareTo(secondNumber);
	}
}