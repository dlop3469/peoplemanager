package com.examples.peoplemanager.service.mock;

import com.examples.peoplemanager.model.Gender;
import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.ConfigService;
import com.google.inject.Singleton;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class MockConfigService implements ConfigService {
    @Override
    public List<Person> load() {
        List<Person> people = new ArrayList<Person>();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");

        Person bill = new Person("Bill", "McKnight", Gender.MALE, dtf.parseDateTime("16/03/77"));
        Person paul = new Person("Paul", "Robinson", Gender.MALE, dtf.parseDateTime("15/01/85"));
        Person gemma = new Person("Gemma", "Lane", Gender.FEMALE, dtf.parseDateTime("20/11/91"));
        Person sarah = new Person("Sarah", "Stone", Gender.MALE, dtf.parseDateTime("20/09/80"));
        Person wes = new Person("Wes", "Jackson", Gender.MALE, dtf.parseDateTime("14/08/74"));

        people.add(bill);
        people.add(paul);
        people.add(gemma);
        people.add(sarah);
        people.add(wes);

        return people;
    }
}
