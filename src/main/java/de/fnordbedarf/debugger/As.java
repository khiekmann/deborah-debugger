package de.fnordbedarf.debugger;

/**
 * Created by HiekmaHe on 04.05.2017.
 *
 */
public enum As
{
	notSet ("none specified"),
	notNull("not null"),
	null_("null"),
	true_("true"),
	false_("false"),
	equal("equal to"),
	greaterThan("greater than"),
	notEqual("not equal"),
	lessThan("less than"),
	greaterThanOrEqualTo("greater than or equal to"),
	empty("empty"),
	notEmpty("not empty"),
	anArray("an array"),
	notAnArray("not an array"),
	havingTheSameElements("having the same elements");

	public final String description;

	As(String description)
	{
		this.description = description;
	}
}
