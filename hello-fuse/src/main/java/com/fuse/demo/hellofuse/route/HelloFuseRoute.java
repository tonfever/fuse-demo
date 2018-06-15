package com.fuse.demo.hellofuse.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class HelloFuseRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:work/cbr/input")
            .routeId("Moving Files Route")
            .log(LoggingLevel.INFO, "Receiving order ${file:name}")
            .choice()
                .when()
                    .xpath("//country = 'UK'")
                    .log(LoggingLevel.INFO, "Sending order ${file:name} to the UK")
                    .to("file:work/cbr/output/uk")
                .endChoice()
                /*.when()
                    .xpath("//order:order//order:customer//order:country = 'US'")
                    .log("Sending order ${file:name} to the US")
                    .to("file:work/cbr/output/us")
                .endChoice()*/
                .otherwise()
                    .log(LoggingLevel.INFO, "Sending order ${file:name} to another country")
                    .to("file:work/output/others")
        .end();

    }
}
