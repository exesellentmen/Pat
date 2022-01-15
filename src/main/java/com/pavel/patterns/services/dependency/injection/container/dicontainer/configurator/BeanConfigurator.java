package com.pavel.patterns.services.dependency.injection.container.dicontainer.configurator;


import org.reflections.Reflections;

public interface BeanConfigurator {
    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);
    Reflections getScanner();
}
