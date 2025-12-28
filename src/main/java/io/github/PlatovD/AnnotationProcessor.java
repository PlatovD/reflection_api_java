package io.github.PlatovD;

import io.github.PlatovD.annotation.Service;
import io.github.PlatovD.service.LazyService;
import io.github.PlatovD.service.SimpleService;

public class AnnotationProcessor {
    public static void main(String[] args) {
        interspectService(SimpleService.class);
        interspectService(LazyService.class);
        interspectService(String.class);
    }

    static void interspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println("Annotation @Service exists on " + service.getName());
        } else {
            System.out.println("Annotation @Service wasn't found");
        }
    }
}
