package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by da3mon on 2016.09.22..
 */

@RestController
public class GreeterRestService {

    @Value("${greeter.message:Hello, %s !}")
    public String message;
    public final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeter/{name}")
    public Greeting greetingWithName(@PathVariable String name){
        return new Greeting(counter.incrementAndGet(), String.format(message, name));
    }

    @GetMapping("/greeter")
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(message, name));
    }
}
