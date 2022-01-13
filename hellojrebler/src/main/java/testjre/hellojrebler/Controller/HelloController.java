package testjre.hellojrebler.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
    public  String test(){
        System.out.println("test fd ok");
        return "hello123444444";
    }
}
