package com.vobject.flutter.widgets.explorer;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import javax.validation.constraints.NotNull;

@Controller("/ping")
public class PingController {
    
    @Get("/{value:'pong'}")
    public String pong(@NotNull String value) {
        return "ping " + value;
    }
}
