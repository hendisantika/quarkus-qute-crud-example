package com.hendisantika.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

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
}
