package io.github.PlatovD.service;

import io.github.PlatovD.annotation.Init;
import io.github.PlatovD.annotation.Service;

@Service(name = "superSimple")
public class SimpleService {
    @Init
    public void initService() {
        System.out.println("Simple");
    }

    public void notInit() {
        System.out.println("Not init");
    }
}
