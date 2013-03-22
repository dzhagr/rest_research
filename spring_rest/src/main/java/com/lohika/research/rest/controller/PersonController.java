package com.lohika.research.rest.controller;

import com.lohika.research.rest.core.DataProvider;
import com.lohika.research.rest.core.Person;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class PersonController implements ApplicationContextAware {


    @Value("${personController.replace.all.msg}")
    private String replaceAllMsgTemplate;
    private DataProvider dataProvider;

    @RequestMapping(value = "/{personId}")
    @ResponseBody
    public Person get(@PathVariable Long personId, HttpServletResponse response) {
        Person person = dataProvider.getPersonById(personId);
        if (person == null) {
            throw new ObjectNotFoundException();
        }
        return person;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Person> getAll() {
        return dataProvider.getAllPeople();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Person person, HttpServletRequest request, HttpServletResponse response) {
        Long personId = dataProvider.createPerson(person);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setHeader("Location", request.getRequestURL().append("/").append(personId).toString());
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String replaceAll(@RequestBody Collection<Person> people) {
        dataProvider.replaceAllPeople(people);
        return String.format(replaceAllMsgTemplate, people.size());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        dataProvider = (DataProvider) applicationContext.getBean("dataProviderImpl");
    }
}