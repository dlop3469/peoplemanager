package com.examples.peoplemanager.service;

public interface PeopleService<T> {
    public T add(T item);
    public T getOldestPerson();
    public int getNumberOfMales();
    public int daysBetween(T i1, T i2);
    public void load();
    public int daysBetweenByName(String name1, String name2);
}
