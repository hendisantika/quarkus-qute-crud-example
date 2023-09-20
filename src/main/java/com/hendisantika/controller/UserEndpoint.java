package com.hendisantika.controller;

import com.hendisantika.repository.UserResource;
import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-qute-crud-example
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 9/20/2023
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
public class UserEndpoint {

    @Inject
    Template home;

    @Inject
    Template createupdate;

    @Inject
    UserResource userResource;
}
