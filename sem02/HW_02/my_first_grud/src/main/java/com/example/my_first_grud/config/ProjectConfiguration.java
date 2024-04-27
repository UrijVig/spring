package com.example.my_first_grud.config;

import com.example.my_first_grud.aspect.TrackUserActionAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.my_first_grud")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public TrackUserActionAspect trackUserActionAspect(){
        return new TrackUserActionAspect();
    }
}
