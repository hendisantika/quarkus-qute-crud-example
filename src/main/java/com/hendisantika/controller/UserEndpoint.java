package com.hendisantika.controller;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserResource;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateException;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Map;

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

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllUserView()
            throws TemplateException {
        List<User> users = userResource.getUsers();
        return home.data(Map.of("users", users));
    }
}
