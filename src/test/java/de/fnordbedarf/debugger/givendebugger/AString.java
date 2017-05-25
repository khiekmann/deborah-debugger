package de.fnordbedarf.debugger.givendebugger;

import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static de.fnordbedarf.debugger.Debugger.show;

/**
 * Created by lora on 25.05.17.
 */
public class AString {

    private Object newObjectToString = "hello";

    @Test
    public void whenNewObjectToStringThenToBeEqualToNewObjectToString() {
        Object newObject = new Object().toString();
        show(newObjectToString);
        show(newObject.toString());
    }
}
