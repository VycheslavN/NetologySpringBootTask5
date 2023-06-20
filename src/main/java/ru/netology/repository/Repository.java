package ru.netology.repository;

import ru.netology.entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager manager;

    /* создайте метод getPersonsByCity(String city), который будет принимать название города и
    возвращать ваше Entity из базы данных, которые соответствуют этому city. Сделать это можно,
     например, получив всех пользователей и отфильтровав их по городу.*/

    public List<Person> getPersonsByCity(String city) {
        return manager.createQuery("SELECT p FROM Person p WHERE p.city_of_living = :city")
                .setParameter("city",city).getResultList();
    }
}
