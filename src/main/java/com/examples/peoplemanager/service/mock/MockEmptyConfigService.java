package com.examples.peoplemanager.service.mock;

import com.examples.peoplemanager.model.Person;
import com.examples.peoplemanager.service.ConfigService;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock emtpy list of people read from a file
 */
public class MockEmptyConfigService implements ConfigService {
    @Override
    public List<Person> load() {
        return new ArrayList<Person>();
    }
}
