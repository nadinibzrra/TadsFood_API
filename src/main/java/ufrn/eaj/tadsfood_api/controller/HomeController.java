package ufrn.eaj.tadsfood_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {

    @GetMapping("/user")
    public String helloUser() { return "Hello User"; }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @GetMapping("/super")
    public String helloSuper() {
        return "Hello super";
    }

}
