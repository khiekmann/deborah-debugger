package de.fnordbedarf.debugger.givendebugger;

import de.fnordbedarf.debugger.NullObject;
import de.fnordbedarf.debugger.animal.Animal;
import de.fnordbedarf.debugger.animal.Cat;
import de.fnordbedarf.debugger.animal.Dog;
import org.junit.jupiter.api.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static de.fnordbedarf.debugger.Debugger.expectClassOf;

/**
 * Created by lora on 20.05.17.
 *
 */
class ClassOf {

    @Test
    void whenNullThenNotException() {
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
    void whenNewObjectThenEqualToClassOfObject() {
        // arrange act assert
        expectClassOf(new Object()).toBeEqualTo(Object.class).otherwiseComplain();
    }

    @Test
    void whenNewDogThenEqualToClassOfDog() {
        // arrange act assert
        expectClassOf(new Dog()).toBeEqualTo(Dog.class).otherwiseComplain();
    }

    @Test
    void whenNewDogThenToNotEqualToClassOfCat() {
        // arrange act assert
        expectClassOf(new Dog()).toNotBeEqualTo(Cat.class).otherwiseComplain();
    }

    @Test
    void whenNewCatThenToNotEqualToClassOfCat() {
        // arrange act assert
        expectClassOf(new Cat()).toNotBeEqualTo(Dog.class).otherwiseComplain();
    }

    @Test
    void whenNewCatThenToNotEqualToClassOfAnimal() {
        // arrange act assert
        expectClassOf(new Cat()).toNotBeEqualTo(Animal.class).otherwiseComplain();
    }

    @Test
    void whenNullThenNullObject() {
        // arrange act assert
        expectClassOf(null).toBeEqualTo(NullObject.class).otherwiseComplain();
    }

    @Test
    void whenNullObjectThenNullObject() {
        // arrange act assert
        expectClassOf(new NullObject()).toBeEqualTo(NullObject.class).otherwiseComplain();
    }

    @Test
    void whenNotNullThenNotNullObject() {
        // arrange act assert
        expectClassOf(new Object()).toNotBeEqualTo(NullObject.class).otherwiseComplain();
    }
}