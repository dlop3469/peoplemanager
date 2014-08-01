package com.examples.peoplemanager.model;

/**
 * This class defines a person.
 * A person could change its name, surname and gender over their life.
 * The dateOfBirth could not be changed once is created.
 */
public class Person {

    private String name;
    private String surname;
    private Gender gender;
    private final String dateOfBirth;

    public Person(String name, String surname, Gender gender, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isAMale() {
        return gender.equals(Gender.MALE);
    }
}
