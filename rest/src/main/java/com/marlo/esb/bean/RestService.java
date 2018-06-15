package com.marlo.esb.bean;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class RestService
{
    @POST
    @Path("/notify")
    @Consumes("*/*")
    @Produces("application/json")
    public Response notify(String response) {
        return null;
    }

    @GET
    @Path("/health")
    @Consumes("*/*")
    public Response healthCheck(String response) throws Exception{
        return null;
    }
}
