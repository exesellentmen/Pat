package com.pavel.patterns.services.spring.dependency.injection.xml.container;

import com.pavel.patterns.services.spring.dependency.injection.xml.container.services.car.Car;
import com.pavel.patterns.services.spring.dependency.injection.xml.container.services.car.CarInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class DISpringApplication {

    public static void main(String[] args) {

        //Если файл находится в resources
//        ApplicationContext XmlContext = new ClassPathXmlApplicationContext("/com/pavel/patterns/services/spring/dependency/injection/xml/container/springconfig.xml");

        ApplicationContext XmlContext = new FileSystemXmlApplicationContext("src/main/java/com/pavel/patterns/services/spring/dependency/injection/xml/container/dicontainer/springconfig.xml");




        CarInterface car = XmlContext.getBean(Car.class);
        car.move();






    }

}
