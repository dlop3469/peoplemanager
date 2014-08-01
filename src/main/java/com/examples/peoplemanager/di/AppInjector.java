package com.examples.peoplemanager.di;

import com.examples.peoplemanager.service.MockPeopleService;
import com.examples.peoplemanager.service.PeopleService;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(PeopleService.class).to(MockPeopleService.class);
    }

}
