package com.proyecto.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class jakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping jakarta EE")
                .build();
    }
}
