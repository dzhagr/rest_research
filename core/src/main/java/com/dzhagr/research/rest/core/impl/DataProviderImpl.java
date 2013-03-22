package com.dzhagr.research.rest.core.impl;

import com.dzhagr.research.rest.core.DataProvider;
import com.dzhagr.research.rest.core.Person;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: adzhagriev
 * Date: 3/22/13
 * Time: 2:33 PM
 */
public class DataProviderImpl implements DataProvider {

    private final Map<Long, Person> people = new HashMap<>();
    private final AtomicLong personId = new AtomicLong(0);

    @Override
    public Long createPerson(Person person) {
        long id = personId.incrementAndGet();
        person.setId(id);
        people.put(id, person);
        return id;
    }

    @Override
    public Person getPersonById(Long personId) {
        return people.get(personId);
    }

    @Override
    public Collection<Person> getAllPeople() {
        return people.values();
    }

    @Override
    public void replaceAllPeople(Collection<Person> people) {
        this.people.clear();
        for (Person person : people) {
            this.people.put(person.getId(), person);
        }
    }
}
