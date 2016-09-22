package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by da3mon on 2016.09.22..
 */

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting){
        return "result";
    }

    @RequestMapping("/greeting/{name}")
    public String greetByName(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
