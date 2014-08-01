package com.examples.peoplemanager;

import com.examples.peoplemanager.controller.PeopleManager;
import com.examples.peoplemanager.model.Gender;
import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.ConfigService;
import com.examples.peoplemanager.service.PeopleService;
import com.examples.peoplemanager.service.mock.MockConfigService;
import com.examples.peoplemanager.service.mock.MockEmptyConfigService;
import com.examples.peoplemanager.service.mock.MockPeopleService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeopleManagerMockTest {
    private Injector injector;
    private DateTimeFormatter dtf;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(PeopleService.class).to(MockPeopleService.class);
                bind(ConfigService.class).to(MockConfigService.class);
            }
        });
        dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    @Test
    public final void whenHowManyMalesAreInTheAddressBookReturns4() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Assert.assertEquals(pm.getNumberOfMales(), 4);
    }

    @Test
    public final void whenWhoIsTheOldestPersonInTheAddressBookReturnsWes() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Assert.assertEquals(pm.getOldestPerson().getName(), "Wes");
    }

    @Test
    public final void whenHowManyDaysOlderIsBillThanPaulReturns2862() {
        PeopleManager pm = injector.getInstance(PeopleManager.class);
        Assert.assertEquals(pm.daysBetweenByName("Bill", "Paul"), 2862);
    }


}
