package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.NullObject;
import de.fnordbedarf.debugger.animal.Cat;
import de.fnordbedarf.debugger.animal.Dog;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static de.fnordbedarf.debugger.Debugger.expectClassOf;

/**
 * Created by lora on 20.05.17.
 */
public class ClassOf {

    @Test
    public void whenNullThenNotException() {
        // arrange act assert
        boolean exceptionCaught = false;
        try {
            expectClassOf(null);
        } catch (Exception e) {
            exceptionCaught = true;
        }
        expect(exceptionCaught).toBeFalse().otherwiseComplain();
    }

    @Test
    public void whenNewObjectThenEqualToClassOfObject() {
        // arrange act assert
        expectClassOf(new Object()).toBeEqualTo(Object.class).otherwiseComplain();
    }

    @Test
    public void whenNewDogThenEqualToClassOfDog() {
        // arrange act assert
        expectClassOf(new Dog()).toBeEqualTo(Dog.class).otherwiseComplain();
    }

    @Test
    public void whenNewDogThenToNotEqualToClassOfCat() {
        // arrange act assert
        expectClassOf(new Dog()).toNotBeEqualTo(Cat.class).otherwiseComplain();
    }

    @Test
    public void whenNewCatThenToNotEqualToClassOfCat() {
        // arrange act assert
        expectClassOf(new Cat()).toNotBeEqualTo(Dog.class).otherwiseComplain();
    }

    @Test
    public void whenNullThenNullObject() {
        // arrange act assert
        expectClassOf(null).toBeEqualTo(NullObject.class).otherwiseComplain();
    }

    @Test
    public void whenNullObjectThenNullObject() {
        // arrange act assert
        expectClassOf(new NullObject()).toBeEqualTo(NullObject.class).otherwiseComplain();
    }

    @Test
    public void whenNotNullThenNotNullObject() {
        // arrange act assert
        expectClassOf(new Object()).toNotBeEqualTo(NullObject.class).otherwiseComplain();
    }
}