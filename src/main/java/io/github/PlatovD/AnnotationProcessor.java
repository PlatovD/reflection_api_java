package io.github.PlatovD;

import io.github.PlatovD.annotation.Init;
import io.github.PlatovD.annotation.Service;
import io.github.PlatovD.service.LazyService;
import io.github.PlatovD.service.SimpleService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
    private static Map<String, Object> servicesMap = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        interspectService(SimpleService.class);
        interspectService(LazyService.class);
        interspectService(String.class);

        interspectInitMethods(SimpleService.class);

        loadService("io.github.PlatovD.service.SimpleService");
        SimpleService simpleService = (SimpleService) servicesMap.get("io.github.PlatovD.service.SimpleService");
        simpleService.initService();
    }

    static void loadService(String name) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(name);
        if (clazz.isAnnotationPresent(Service.class)) {
            servicesMap.put(name, clazz.getDeclaredConstructor().newInstance());
        }
    }

    static void interspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println("Annotation @Service exists on " + service.getName());
        } else {
            System.out.println("Annotation @Service wasn't found");
        }
    }

    static void interspectInitMethods(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                System.out.println("Has annotation");
            } else {
                System.out.println("No annotation");
            }
        }
    }
}
