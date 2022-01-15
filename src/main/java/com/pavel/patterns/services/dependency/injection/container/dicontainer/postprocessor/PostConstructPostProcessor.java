package com.pavel.patterns.services.dependency.injection.container.dicontainer.postprocessor;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.annotation.PostConstruct;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class PostConstructPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public void process(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(PostConstruct.class)){
                method.invoke(bean);
            }
        }
    }
}
