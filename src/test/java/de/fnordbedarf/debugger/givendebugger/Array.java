package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.NullObject;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Array {

    private final Integer[] arrayOfIntegers = {1, 2, 3};
    private final long[] arrayOfLongs = {1L, 2L, 3L};
    private final String[] arrayOfStrings = {"a", "b", "c"};
    private final Integer[] sameArrayOfIntegers = {1, 2, 3};

    @Test
    public void whenArrayOfIntegersThenNotNull() {
        expect(arrayOfIntegers).toBeNotNull().otherwiseComplain();
    }

    @Test
    public void whenArrayOfIntegersThenToBeArray() {
        expect(arrayOfIntegers).toBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenArrayOfLongsThenToBeArray() {
        expect(arrayOfLongs).toBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenNewObjectThenNotToBeFalse() {
        expect(new Object()).toNotBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenArrayOfStringThenToBeArray() {
        expect(arrayOfStrings).toBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenNullThenToNotBeAnArray() {
        expect(null).toNotBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenNullObjectThenToNotBeAnArray() {
        expect(new NullObject()).toNotBeAnArray().otherwiseComplain();
    }

    @Test
    public void whenArrayOfIntegersThenToHaveTheSameElementsAsOtherArrayOfIntegers() {
        expect(arrayOfIntegers)
                .toHaveTheSameElementsAs(sameArrayOfIntegers)
                .otherwiseComplain();
    }
}