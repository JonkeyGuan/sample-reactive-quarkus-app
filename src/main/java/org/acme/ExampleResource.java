package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;

@Path("/hello")
public class ExampleResource {

    private ReactiveGreetingService service;

    public ExampleResource(ReactiveGreetingService service) {

        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Uni<String> greeting(String name) {

        return service.greeting(name);
    }
}