package com.pavel.patterns.services.dependency.injection.container.dicontainer.context;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.factory.BeanFactory;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.postprocessor.BeanPostProcessor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap = new ConcurrentHashMap<>();

    public ApplicationContext(){

    }

    public <T> T getBean(Class<T> clazz){
        if (beanMap.containsKey(clazz)){
            return (T) beanMap.get(clazz);
        }

        T bean = beanFactory.getBean(clazz);
        callPostProcessors(bean);

        beanMap.put(clazz, bean);

        return bean;

    }

    @SneakyThrows
    private void callPostProcessors(Object bean){
        for (Class processor : beanFactory.getBeanConfigurator().getScanner().getSubTypesOf(BeanPostProcessor.class)){
            BeanPostProcessor postProcessor = (BeanPostProcessor) processor.getDeclaredConstructor().newInstance();
            postProcessor.process(bean);
        }
    }


}
