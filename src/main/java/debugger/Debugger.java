package debugger;

import java.math.BigDecimal;
import java.util.Comparator;

import org.opentest4j.AssertionFailedError;

import static debugger.Print.print;


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
		return print(object).toConsole();
	}

	public static void exit()
	{
		exit("Debugger shuts down.");
	}

	public static void exit(String message)
	{
		show(message);
		exit(message.hashCode());
	}

	public static void exit(Object object)
	{
		exit(object.hashCode());
	}

	public static void exit(Exception exception)
	{
		exit(exception.getMessage());
	}

	public static void exit(int exitCode)
	{
		System.exit(exitCode);
	}

	public static void sleepFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
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

	public String otherwiseComplain()
	{
		return otherwiseAnnounce(
				N + "\u21AF \'" + classAndStringOf(this_) + "\'"
						+ N + "\u21AF expected to be " + relationToOther.description + " but was"
						+ N + "\u21AF \'" + classAndStringOf(other) + "\'"
						+ N);
	}

	private String classAndStringOf(Object object) {
		String message;
		if (object != null) {
			message = object.getClass() + " " + object ;
			message = message.replace("class ", "");
		} else {
			message = "null";
		}
		return message;
	}

	public String otherwiseMurmur()
	{
		return otherwiseAnnounce("mumble, mumble");
	}

	public String otherwiseAnnounce(String message)
	{
		if (failed()) {
			message = showMessageAndThrowAssertionFailedError(message);
		} else {
			message = "";
		}
		return message;
	}

	private String showMessageAndThrowAssertionFailedError(String message)
	{
		show(message);
		throw new AssertionFailedError(message);
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

	public Debugger toBeEmpty()
	{
		other("Not empty");
		thisRelatesToOther(As.empty);
		passed(thisNotNullAndEmpty());
		return this;
	}

	private boolean thisNotNullAndEmpty()
	{
		boolean isNotNullAndEmpty;
		try {
			isNotNullAndEmpty = this_.toString().isEmpty();
		} catch (Exception e) {
			isNotNullAndEmpty = false;
		}
		return isNotNullAndEmpty;
	}

	public Debugger toNotBeEmpty()
	{
		other("empty");
		thisRelatesToOther(As.notEmpty);
		passed(thisNullAndNotEmpty());
		return this;
	}

	private boolean thisNullAndNotEmpty()
	{
		boolean isNotNullAndNotEmpty;
		try {
			isNotNullAndNotEmpty = ! this_.toString().isEmpty();
		} catch (Exception e) {
			isNotNullAndNotEmpty = false;
		}
		return isNotNullAndNotEmpty;
	}

	public Debugger toBeNotEmpty()
	{
		return toNotBeEmpty();
	}

	public Debugger toBeNotNull()
	{
		return toNotBeNull();
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

	public Debugger toBeLessThan(Number number)
	{
		other(number);
		thisRelatesToOther(As.lessThan);
		passed(compareAsNumber(this_, other) < 0);
		return this;
	}

	public Debugger toBeGreaterThan(Number number)
	{
		other(number);
		thisRelatesToOther(As.greaterThan);
		passed(compareAsNumber(this_, other) > 0);
		return this;
	}

	public Debugger toBeGreaterThanOrEqualTo(Number number)
	{
		other(number);
		thisRelatesToOther(As.greaterThanOrEqualTo);
		passed(compareAsNumber(this_, other) >= 0);
		return this;
	}
}