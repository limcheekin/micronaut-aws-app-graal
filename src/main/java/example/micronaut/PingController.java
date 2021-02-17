package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import javax.validation.constraints.NotNull;

@Controller("/ping")
public class PingController {
    
    @Get
    public String pong() {
        return "pong";
    }
}
