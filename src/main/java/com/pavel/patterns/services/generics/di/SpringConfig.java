package com.pavel.patterns.services.generics.di;

import com.pavel.patterns.services.generics.services.wheel.Wheel;
import com.pavel.patterns.services.generics.services.wheel.WheelInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.pavel.patterns.services.springreflection.services")
public class SpringConfig {

    @Bean
    public WheelInterface wheelInterface(){
        return new Wheel();
    }

}
