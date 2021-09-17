package com.akhilesh.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

/*
    https://www.baeldung.com/properties-with-spring
 */
@Configuration
@EnableWebMvc //Supports Web MVC annotation driven
@ComponentScan(basePackages = "com.akhilesh")
@PropertySource({"classpath:config.properties"})
public class AppConfig implements WebMvcConfigurer {

    //We inject the Environment in order to obtain the properties
    @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());
/*
    <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/view/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
 */
    @Bean
    public ViewResolver viewResolverConfiguration(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
