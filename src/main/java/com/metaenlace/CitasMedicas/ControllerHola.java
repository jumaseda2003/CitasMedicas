package com.metaenlace.CitasMedicas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHola {


    @GetMapping("/")
    public String inicio(){

        return "hello";

    }
    @GetMapping("/login")
    public String login(){

        return "login";

    }
}
