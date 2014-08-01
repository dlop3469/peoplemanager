package com.examples.peoplemanager;

import com.examples.peoplemanager.controller.PeopleManager;
import com.examples.peoplemanager.di.AppInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ClientApplication {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppInjector());

        PeopleManager app = injector.getInstance(PeopleManager.class);

        System.out.println("How many males are in the address book?");
        System.out.println(app.getNumberOfMales());

        System.out.println("Who is the oldest person in the address book?");
        System.out.println(app.getOldestPerson().getName());

        System.out.println("How many days older is Bill than Paul?");
        System.out.println(app.daysBetweenByName("Bill", "Paul"));

        System.exit(0);
    }

}
