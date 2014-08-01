package com.examples.peoplemanager;

import com.examples.peoplemanager.model.Gender;
import com.examples.peoplemanager.model.Person;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1.- How many males are in the address book
 * 2.- Who is the oldest person in the address book?
 * 3.- How many days older is Bill than Paul?
 */

public class PeopleManagerTest {

    private PeopleManager pm;
    private DateTimeFormatter dtf;

    @Before
    public void setUp() {
        pm = new PeopleManager();
        dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    @Test
    public final void whenRequestNumberOfMalesOnEmptyPeopleReturnsNone() {
        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

    @Test
    public final void whenOneMaleInSystemReturnsOne() {
        Person joe = (new Person("Joe", "Surname", Gender.MALE,  dtf.parseDateTime("16/03/77")));

        pm.add(joe);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenOneMaleAndOneFemaleInSystemReturnsOne() {
        Person joe = (new Person("Joe", "Surname", Gender.MALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(joe);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenTwoFemaleAndNoMaleReturnsNone() {
        Person anna = (new Person("Anna", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(anna);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

    @Test
    public final void whenCheckOldestPersonShouldBeTheOneWithOlderDayOfBirth() {
        Person anna = (new Person("Anna", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(anna);
        pm.add(maria);

        Assert.assertEquals(pm.getOldestPerson(), anna);
    }

}
