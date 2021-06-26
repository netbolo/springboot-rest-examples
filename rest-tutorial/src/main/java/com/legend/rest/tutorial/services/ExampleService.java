package com.legend.rest.tutorial.services;

import org.springframework.stereotype.Service;

import com.legend.rest.tutorial.requestresponsebody.LoginForm;

@Service
public class ExampleService {

    public boolean fakeAuthenticate(LoginForm lf) {
        return true;
    }
}
