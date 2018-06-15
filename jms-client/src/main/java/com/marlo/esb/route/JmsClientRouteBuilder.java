package com.marlo.esb.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

public class JmsClientRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("jms:queue:employeeQueue")
            .routeId("jmsEmployeeQueueRoute")
            .log(LoggingLevel.INFO, "Getting Message from Queue ${body}")
            .to("doSomethingProcessor")
            .to("file:work/jms-client?fileName="+UUID.randomUUID()+".json");

    }
}
