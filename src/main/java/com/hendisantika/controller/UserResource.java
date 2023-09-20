package com.hendisantika.controller;

import com.hendisantika.entity.User;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-qute-crud-example
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 9/20/2023
 * Time: 7:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class UserResource {

    @Inject
    EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("SELECT c FROM User c").getResultList();
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

}
