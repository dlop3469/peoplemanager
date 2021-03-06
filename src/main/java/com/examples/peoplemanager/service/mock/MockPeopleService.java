package com.examples.peoplemanager.service.mock;

import java.util.*;

import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.ConfigService;
import com.examples.peoplemanager.service.PeopleService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.joda.time.Days;

@Singleton
public class MockPeopleService implements PeopleService<Person> {
    private static int numberOfMales;
    private Map<String,Person> people;
    private static Person oldest;

    private ConfigService cs;

    @Inject
    public MockPeopleService(ConfigService cs) {
        this.cs = cs;
        people = new HashMap<String,Person>();
        numberOfMales = 0;
        load();
    }

    @Override
    public Person add(Person p) {
        people.put(p.getName(), p);
        if (p.isAMale()) numberOfMales++;
        if (oldest == null || p.getDateOfBirth().isBefore(oldest.getDateOfBirth())) oldest = p;
        return p;
    }

    @Override
    public int getNumberOfMales() {
        return numberOfMales;
    }

    @Override
    public int daysBetween(Person i1, Person i2) {
        Days d = Days.daysBetween(i1.getDateOfBirth(), i2.getDateOfBirth());
        return d.getDays();
    }

    public int daysBetweenByName(String name1, String name2) {
        Person p1 = people.get(name1);
        Person p2 = people.get(name2);

        return daysBetween(p1, p2);
    }

    /**
     * Load configuration from Mock data.
     */
    @Override
    public void load() {
        for (Person p: cs.load())
            add(p);
    }

    @Override
    public Person getOldestPerson() {
        return oldest;
    }
}
