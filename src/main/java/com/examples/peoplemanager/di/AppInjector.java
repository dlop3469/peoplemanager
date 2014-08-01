package com.examples.peoplemanager.di;

import com.examples.peoplemanager.service.ConfigService;
import com.examples.peoplemanager.service.mock.MockConfigService;
import com.examples.peoplemanager.service.mock.MockPeopleService;
import com.examples.peoplemanager.service.PeopleService;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(PeopleService.class).to(MockPeopleService.class);
        bind(ConfigService.class).to(MockConfigService.class);
    }

}
