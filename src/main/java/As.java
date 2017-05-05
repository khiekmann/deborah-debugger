/**
 * Created by HiekmaHe on 04.05.2017.
 */
public enum As
{
	notSet ("none specified"),
	notNull("not null"),
	null_("null"),
	true_("true"),
	false_("false"),
	equal("equal to"),
	greaterThan("greater Than"),
	notEqual("not equal"),
	lessThan("less than");

	public final String description;

	As(String description)
	{
		this.description = description;
	}
}
