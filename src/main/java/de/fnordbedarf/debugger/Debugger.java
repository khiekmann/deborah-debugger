package de.fnordbedarf.debugger;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public class Debugger
{
	private final static String n = System.getProperty("line.separator");
	private final static String murmur = "assertion error.";
	private static final Logger logger = Logger.getLogger(Debugger.class.getCanonicalName());

	private final Object this_;

	private Object other;
	private As relationToOther;
	private boolean passed = false;

	public static String show(Object object) {
		return Print.print(object).toConsole();
	}

	public static void exit()
	{
		exit("Debugger shuts down.");
	}

	private static void exit(String message)
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

	public static Debugger expectClassOf(Object object)
	{
		return new Debugger(classOf(object));
	}

	private static Object classOf(Object object) {
		if (object == null) {
			object = new NullObject();
		}
		return object.getClass();
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
		if (object instanceof Debugger) {
			isEqual = (hashCode() == object.hashCode());
		}
		return isEqual;
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
		return otherwiseAnnounce(complainMessage());
	}

	private String complainMessage() {
		return  n + "\u21AF \'" + classAndStringOf(this_) + "\'"
				+ n + "\u21AF expected to be " + relationToOther.description + " but was"
				+ n + "\u21AF \'" + classAndStringOf(other) + "\'"
				+ n;
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
		return otherwiseAnnounce(murmur);
	}

	public String otherwiseAnnounce(String message)
	{
		if (failed()) {
			message = showAndThrowAssertionFailedError(message);
		} else {
			message = "";
		}
		return message;
	}

	public String otherwiseLog()
	{
		return otherwiseLogAs(Level.SEVERE);
	}

	public String otherwiseLogAs(Level level)
	{
		String complainMessage = this.complainMessage();
		logger.log(level, complainMessage);
		return complainMessage;
	}

	private String showAndThrowAssertionFailedError(String message)
	{
		show(message);
		return fail(message);
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

	private int compareAsNumber(Object first, Object second) {
        BigDecimal firstNumber = new BigDecimal(String.valueOf(first));
        BigDecimal secondNumber = new BigDecimal(String.valueOf(second));
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

	public Debugger toBeNotEqualTo(Object object)
	{
		other(object);
		thisRelatesToOther(As.notEqual);
		passed(! thisObjectEqualsToOtherObject());
		return this;
	}

	public Debugger toNotBeEqualTo(Object object)
	{
		return toBeNotEqualTo(object);
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

	private static String fail(String message)
	{
		throw new AssertionFailedError(message);
	}

	public Debugger toBeAnArray() {
		other(String.valueOf("Array expected"));
		thisRelatesToOther(As.anArray);
        passed(thisIsAnArray());
		return this;
	}

    private boolean thisIsAnArray() {
	    boolean isArray = false;
	    if (this_ != null) { isArray = isArray(this_); }
        return isArray;
    }

    private boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    public Debugger toNotBeAnArray() {
        other(String.valueOf("No Array expected"));
        thisRelatesToOther(As.notAnArray);
        passed(thisIsNotAnArray());
        return this;
    }

    private boolean thisIsNotAnArray() {
        return ! thisIsAnArray();
    }

    public Debugger toHaveTheSameElementsAs(Object array) {
        other(array);
        thisRelatesToOther(As.havingTheSameElements);
        passed(allElementsAreEqual());
        return this;
    }

    private boolean allElementsAreEqual() {
	    boolean allElementsAreEqual = false;
	    if (isArray(this_)) {
	        if (isArray(other)) {
	            int thisLength = Array.getLength(this_);
	            int otherLength = Array.getLength(other);
	            if (thisLength == otherLength) {
	                for (int i = 0; i < thisLength; i++) {
	                    Object thisObject = Array.get(this_, i);
	                    Object otherObject = Array.get(other, i);
	                    if (thisObject.equals(otherObject)) {
	                        allElementsAreEqual = true;
                        } else {
	                        allElementsAreEqual = false;
	                        break;
                        }
                    }
                }
            }
        }
        return allElementsAreEqual;
    }
}