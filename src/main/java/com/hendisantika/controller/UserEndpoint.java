package com.hendisantika.controller;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserResource;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateException;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.HashMap;
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

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance createUserView()
            throws TemplateException, IOException {
        User user = new User();
        Map<String, Object> obj = new HashMap<>();
        obj.put("user", user);
        obj.put("isUpdate", false);
        return createupdate.data(obj);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public TemplateInstance createUser
            (@FormParam("firstName") String firstName,
             @FormParam("lastName") String lastName,
             @FormParam("email") String email)
            throws TemplateException {
        User usr = new User();
        usr.setEmail(email);
        usr.setFirstName(firstName);
        usr.setLastName(lastName);
        userResource.addUser(usr);
        return getAllUserView();
    }
}
