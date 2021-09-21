package com.akhilesh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource source;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(source);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //Request access based on HttpServletRequest
                .antMatchers("/").hasRole("USER")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .and().formLogin().loginPage("/showlogin")  //To get login page
                .loginProcessingUrl("/authenticateUser") //Post mapping for authenticating users
                .permitAll() //Specifies that all security roles are allowed
                .and() //and() method is used to concatenate multiple configurer of Spring Security
                .logout() //Logout Support
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
