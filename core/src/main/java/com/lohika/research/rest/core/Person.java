package com.lohika.research.rest.core;

/**
 * Author: adzhagriev
 * Date: 3/21/13
 * Time: 1:48 PM
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Long birthDate;

    public Person(Long id, String firstName, String lastName, Long birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }
}
