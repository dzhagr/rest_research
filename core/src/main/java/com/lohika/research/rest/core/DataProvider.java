package com.lohika.research.rest.core;

import java.util.Collection;

/**
 * Author: adzhagriev
 * Date: 3/22/13
 * Time: 2:33 PM
 */
public interface DataProvider {
    public Long createPerson(Person person);

    public Person getPersonById(Long personId);

    public Collection<Person> getAllPeople();

    public void replaceAllPeople(Collection<Person> people);
}
