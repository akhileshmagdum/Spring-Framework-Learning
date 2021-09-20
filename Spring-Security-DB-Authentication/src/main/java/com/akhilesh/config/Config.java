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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.akhilesh")
@PropertySource("classpath:dbconfig.properties")
public class Config {

    @Autowired
    private Environment env; // To access files from properties file

    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource source = new ComboPooledDataSource();

        try {
            source.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        source.setJdbcUrl(env.getProperty("jdbc.url"));
        source.setUser(env.getProperty("jdbc.user"));
        source.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        source.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        source.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        source.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        source.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return source;
    }

    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }
}
