package com.FirstApp.demo.Service;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    public String retrieveWelcomeMessage(){
        return "Good Morning Updated";
    }
}
