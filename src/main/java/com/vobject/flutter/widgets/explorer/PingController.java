package com.vobject.flutter.widgets.explorer;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/ping")
public class PingController {
    
    @Get
    public String pong() {
        return "pong";
    }
}
