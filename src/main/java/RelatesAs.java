/**
 * Created by HiekmaHe on 04.05.2017.
 */
public enum RelatesAs
{
	notSet ("none specified"),
	notNull("not null"),
	null_("null"),
	true_("true"),
	false_("false"),
	equal("equal to");

	public final String description;

	RelatesAs(String description)
	{
		this.description = description;
	}
}
