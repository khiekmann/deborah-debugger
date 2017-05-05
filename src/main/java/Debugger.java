import java.math.BigDecimal;
import java.util.Comparator;

import org.opentest4j.AssertionFailedError;


/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public class Debugger
{
	private final static String N = System.getProperty("line.separator");
	private final Object this_;

	private Object other;
	private As relationToOther;
	private boolean passed = false;

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
		passed = false;
		relationToOther = As.notSet;
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

	private void thisRelatesToOther(As relation)
	{
		this.relationToOther = relation;
	}

	// Methods used for feedback

	private boolean failed()
	{
		return ! passed;
	}


	public void otherwiseAnnounce(String message)
	{
		System.err.println(message);
		if (failed()) {
			throw new AssertionFailedError(message);
		}
	}

	public void otherwiseComplain()
	{
		otherwiseAnnounce(
				N + "\u21AF \'" + classAndStringOf(this_) + "\'"
						+ N + "\u21AF expected to be " + relationToOther
						+ N + "\u21AF \'" + classAndStringOf(other) + "\'"
						+ N + "\u21AF Ex falso quodlibet!" );
	}

	private String classAndStringOf(Object object) {
		String message;
		if (object != null) {
			message = object.getClass() + ": " + object ;
		} else {
			message = "class null: null-object";
		}
		return message;
	}

	public void otherwiseMurmur()
	{
		otherwiseAnnounce("");
	}

	// Methods comparing thisObject with otherObject

	private void passed(boolean passed)
	{
		this.passed = passed;
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

	public int compareAsNumber(Object first, Object second) {
		BigDecimal firstNumber = new BigDecimal(first.toString());
		BigDecimal secondNumber = new BigDecimal(second.toString());
		return firstNumber.compareTo(secondNumber);
	}

	public Debugger toBeNull()
	{
		thisRelatesToOther(As.null_);
		passed(this_ == null);
		return this;
	}

	public Debugger toNotBeNull()
	{
		thisRelatesToOther(As.notNull);
		passed(this_ != null);
		return this;
	}

	public Debugger toBeTrue()
	{
		other(Boolean.TRUE);
		thisRelatesToOther(As.true_);
		passed(this_ == Boolean.TRUE);
		return this;
	}

	public Debugger toBeFalse()
	{
		other(Boolean.FALSE);
		thisRelatesToOther(As.false_);
		passed(this_ == Boolean.FALSE);
		return this;
	}

	public Debugger toBeEqualTo(Object object)
	{
		other(object);
		thisRelatesToOther(As.equal);
		passed(thisObjectEqualsToOtherObject());
		return this;
	}

	public Debugger toBeEqualTo(Object object, Comparator comparator) {
		other(object);
		thisRelatesToOther(As.equal);
		passed(comparator.compare(this_, other) == 0);
		return this;
	}

	public Debugger toBeEqualTo(Number number)
	{
		other(number);
		thisRelatesToOther(As.equal);
		passed(compareAsNumber(this_, other) == 0);
		return this;
	}

	public Debugger toBeNotEqualTo(Number number)
	{
		other(number);
		thisRelatesToOther(As.notEqual);
		passed(compareAsNumber(this_, other) != 0);
		return this;
	}
}