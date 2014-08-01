package com.examples.peoplemanager.service;

import java.util.ArrayList;
import java.util.List;
import com.examples.peoplemanager.model.Person;
import com.google.inject.Singleton;
import org.joda.time.Days;

@Singleton
public class MockPeopleService implements PeopleService<Person> {
    private static int numberOfMales;
    private List<Person> people;
    private static Person oldest;

    public MockPeopleService() {
        people = new ArrayList<Person>();
        numberOfMales = 0;
    }

    @Override
    public Person add(Person p) {
        people.add(p);
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

    @Override
    public void load() {

    }

    @Override
    public Person getOldestPerson() {
        return oldest;
    }
}
