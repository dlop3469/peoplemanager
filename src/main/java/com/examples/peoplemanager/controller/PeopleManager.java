package com.examples.peoplemanager.controller;

import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.PeopleService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PeopleManager {

    private PeopleService ps;

    @Inject
    public PeopleManager(PeopleService ps) {
        this.ps = ps;
    }

    public void add(Person person) {
        ps.add(person);
    }

    public int getNumberOfMales() {
        return ps.getNumberOfMales();
    }

    public Person getOldestPerson() {
        return (Person) ps.getOldestPerson();
    }

    public int daysBetween(Person p1, Person p2) {
        return ps.daysBetween(p1, p2);
    }

    public int daysBetweenByName(final String name1, final String name2) {
        return ps.daysBetweenByName(name1, name2);
    }

}
