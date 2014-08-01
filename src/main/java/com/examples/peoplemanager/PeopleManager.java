package com.examples.peoplemanager;

import com.examples.peoplemanager.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by david on 01/08/14.
 */
public class PeopleManager {

    private static int numberOfMales;
    private List<Person> people;
    private static Person oldest;

    public PeopleManager() {
        numberOfMales = 0;
        people = new ArrayList<Person>();
    }

    public int getNumberOfMales() {
        return numberOfMales;
    }

    public void add(Person p) {
        people.add(p);
        if (p.isAMale()) numberOfMales++;
        if (oldest == null || p.getDateOfBirth().isBefore(oldest.getDateOfBirth())) oldest = p;
    }

    public Person getOldestPerson() {
        return oldest;
    }
}
