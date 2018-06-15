package com.marlo.esb.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

public class RestRouteBuilder extends RouteBuilder {


    private static final String REST_API_ENDPOINT = "cxfrs://bean://rsServer?bindingStyle=SimpleConsumer";

    @Override
    public void configure() throws Exception {

        UUID uuid = UUID.randomUUID();

        from(REST_API_ENDPOINT)
            .routeId("com.marlo.esb.route.RestRoute")
            .log(LoggingLevel.INFO, "Payload: ${body}, Headers: ${headers}")
            .wireTap("direct:subRoute")
            .to("file:work/notify?fileName="+uuid+".json");


        from("direct:subRoute")
            .routeId("com.marlo.esb.route.SubRestRoute1")
            .log(LoggingLevel.INFO, "Publishing messages Payload: ${body}")
            .to("jms:queue:employeeQueue");

    }
}
