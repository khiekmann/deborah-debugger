package de.fnordbedarf.debugger.givenprint;

import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static de.fnordbedarf.debugger.Debugger.show;

/**
 * Created by lora on 25.05.17.
 */
public class ShowArray {

    Integer[] integers = new Integer[]{0,1,2};

    @Test
    public void whenArrayOfIntegersToBeShownThenShowArrayOfIntegers() {
        String message = show(integers);
        expect(message)
                .toBeEqualTo(".(ShowArray.java:17): java.lang.Integer[] [ 0, 1, 2, ]")
                .otherwiseComplain();
    }
}
