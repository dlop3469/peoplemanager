package com.examples.peoplemanager;

import com.examples.peoplemanager.model.Gender;
import com.examples.peoplemanager.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1.- How many males are in the address book
 * 2.- Who is the oldest person in the address book?
 * 3.- How many days older is Bill than Paul?
 */

public class PeopleManagerTest {

    @Test
    public final void whenRequestNumberOfMalesOnEmptyPeopleReturnsNone() {
        PeopleManager pm = new PeopleManager();

        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

    @Test
    public final void whenOneMaleInSystemReturnsOne() {
        PeopleManager pm = new PeopleManager();
        Person joe = (new Person("Joe", "Surname", Gender.MALE, "1980-02-02"));

        pm.add(joe);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenOneMaleAndOneFemaleInSystemReturnsOne() {
        PeopleManager pm = new PeopleManager();
        Person joe = (new Person("Joe", "Surname", Gender.MALE, "1980-02-02"));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE, "1985-02-02"));

        pm.add(joe);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenTwoFemaleAndNoMaleReturnsNone() {
        PeopleManager pm = new PeopleManager();
        Person anna = (new Person("Anna", "Surname", Gender.FEMALE, "1980-02-02"));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE, "1985-02-02"));

        pm.add(anna);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

}
