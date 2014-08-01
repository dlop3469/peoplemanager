package com.examples.peoplemanager;

import com.examples.peoplemanager.controller.PeopleManager;
import com.examples.peoplemanager.model.Gender;
import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.MockPeopleService;
import com.examples.peoplemanager.service.PeopleService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1.- How many males are in the address book
 * 2.- Who is the oldest person in the address book?
 * 3.- How many days older is Bill than Paul?
 */

public class PeopleManagerTest {

    private Injector injector;
    private DateTimeFormatter dtf;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(PeopleService.class).to(MockPeopleService.class);
            }
        });
        dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    @Test
    public final void whenRequestNumberOfMalesOnEmptyPeopleReturnsNone() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

    @Test
    public final void whenOneMaleInSystemReturnsOne() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Person joe = (new Person("Joe", "Surname", Gender.MALE,  dtf.parseDateTime("16/03/77")));

        pm.add(joe);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenOneMaleAndOneFemaleInSystemReturnsOne() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Person joe = (new Person("Joe", "Surname", Gender.MALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(joe);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 1);
    }

    @Test
    public final void whenTwoFemaleAndNoMaleReturnsNone() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Person anna = (new Person("Anna", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(anna);
        pm.add(maria);

        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }

    @Test
    public final void whenCheckOldestPersonShouldBeTheOneWithOlderDayOfBirth() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Person anna = (new Person("Anna", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/77")));
        Person maria = (new Person("Maria", "Surname", Gender.FEMALE,  dtf.parseDateTime("16/03/78")));

        pm.add(anna);
        pm.add(maria);

        Assert.assertEquals(pm.getOldestPerson(), anna);
    }

    @Test
    public final void whenCheckDaysBetweenPeopleInAMonthBirthDifferenceShouldBe31() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);

        Person p1 = new Person("Joe", "Surname", Gender.MALE, dtf.parseDateTime("16/03/77"));
        Person p2 = new Person("Pepito", "Surname", Gender.FEMALE, dtf.parseDateTime("16/04/77"));

        Assert.assertEquals(pm.daysBetween(p1, p2), 31);
        Assert.assertEquals(pm.daysBetween(p2, p1), -31);
    }

    @Test
    public final void WhenCheckHowManyDaysOlderIsBillThanPaulShouldBe2862() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);

        Person bill = new Person("Bill", "McKnight", Gender.MALE, dtf.parseDateTime("16/03/77"));
        Person paul = new Person("Paul", "Robinson", Gender.MALE, dtf.parseDateTime("15/01/85"));

        pm.add(bill);
        pm.add(paul);

        Assert.assertEquals(pm.daysBetweenByName("Bill", "Paul"), 2862);
    }

}
