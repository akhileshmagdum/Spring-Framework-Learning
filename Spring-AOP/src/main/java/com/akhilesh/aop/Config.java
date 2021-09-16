package com.akhilesh.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //For No xml
@EnableAspectJAutoProxy //Spring AOP proxy support
@ComponentScan("com.akhilesh") //Package to scan component and aspects
public class Config {
}
