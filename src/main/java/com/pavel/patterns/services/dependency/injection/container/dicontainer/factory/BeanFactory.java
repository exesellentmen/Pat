package com.pavel.patterns.services.dependency.injection.container.dicontainer.factory;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.annotation.Inject;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.config.Configuration;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.config.JavaConfiguration;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.configurator.BeanConfigurator;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.configurator.JavaBeanConfigurator;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.context.ApplicationContext;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;
    @Getter
    private final BeanConfigurator beanConfigurator;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext){
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementations());
        this.applicationContext = applicationContext;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> clazz){
        //Какой-то класс расширин от класса T
        Class<? extends T> implementationClass = clazz;

        //Если implementationClass является интерфейсом
        if(implementationClass.isInterface()){
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }

        T bean = implementationClass.getDeclaredConstructor().newInstance();

        for(Field field : Arrays.stream(implementationClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).collect(Collectors.toList())){
            field.setAccessible(true);
            field.set(bean, applicationContext.getBean(field.getType()));
        }

        return bean;

    }



}
