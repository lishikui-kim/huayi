package com.example.mimile;

import com.example.mimile.beans.Address;
import com.example.mimile.beans.Family;
import com.example.mimile.beans.Person;
import com.example.mimile.dao.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RedisTests {
    @Autowired
    private PersonRepository repository;

    @Test
    public void savePerson() {
        Person person = new Person("ivy", "li");
        Address address = new Address("beijing", "china");
        person.setAddress(address);

        List<Family> familyList = new ArrayList<>();
        Family family1 = new Family("父亲", "老张");
        Family family2 = new Family("母亲", "李夫人");
        familyList.add(family1);
        familyList.add(family2);

        person.setFamilyList(familyList);

        Person save = repository.save(person);
        System.out.println(save);

    }

    @Test
    public void getPerson() {
        List<Person> list = repository.findByAddress_City("beijing");
        System.out.println(list);
    }

    @Test
    public void UpdatePerson() {
        Person person = repository.findByFirstnameAndLastname("ivy", "li").get(0);
        person.setLastname("luce");
        Person update = repository.save(person);
        System.out.println(update);
    }

    @Test
    public void delPerson() {
        Person person = repository.findByFirstnameAndLastname("ivy", "luce").get(0);
        repository.delete(person);
    }
}
