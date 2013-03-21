package com.lohika.research.rest.controller;

import com.lohika.research.rest.core.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Author: adzhagriev
 * Date: 3/21/13
 * Time: 2:02 PM
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Value("${personController.replace.all.msg}")
    private String replaceAllMsgTemplate;

    @RequestMapping(value = "/{personId}")
    @ResponseBody
    public Person get(@PathVariable Long personId) {
        //TODO-AD: replace this dummy with DB access
        return new Person(personId, "Paul", "Smith", new Date().getTime());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Person> getAll() {
        //TODO-AD: replace this dummy with DB access
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person(1L, "Paul", "Smith", new Date().getTime()));
        people.add(new Person(2L, "Max", "Planck", new Date().getTime()));
        return people;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Person person, HttpServletRequest request) {
        //TODO-AD: replace this dummy with DB access
        return request.getRequestURL().append("/").append(25).toString();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String replaceAll(@RequestBody Collection<Person> people) {
        //TODO-AD: replace this dummy with DB access
        return String.format(replaceAllMsgTemplate, people.size());
    }

}