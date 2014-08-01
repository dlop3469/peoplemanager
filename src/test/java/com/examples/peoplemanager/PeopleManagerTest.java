package com.examples.peoplemanager;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1.- How many males are in the address book
 * 2.- Who is the oldest person in the address book?
 * 3.- How many days older is Bill than Paul?
 */

public class PeopleManagerTest {

    @Test
    public final void whenRequestNumberOfMalesOnEmptyPeopleReturnsNone() {
        PeopleManager pm = new Peoplemanager();

        Assert.assertEquals(pm.getNumberOfMales(), 0);
    }
}
