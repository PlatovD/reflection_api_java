package io.github.PlatovD.service;

import io.github.PlatovD.annotation.Init;
import io.github.PlatovD.annotation.Service;

@Service(name = "superLazy")
public class LazyService {
    @Init
    public void lazyInit() throws Exception {
        System.out.println("Lazy");
    }
}
