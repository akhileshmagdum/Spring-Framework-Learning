package com.akhilesh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("Akhilesh").password("test123").roles("MANAGER"))
                .withUser(users.username("Purva").password("test123").roles("USER"))
                .withUser(users.username("Aai").password("test123").roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(). //Request access based on HttpServletRequest
                anyRequest().authenticated(). //Any request to the app must be authenticated
                and().formLogin().loginPage("/showlogin").  //To get login page
                loginProcessingUrl("/authenticateUser"). //Post mapping for authenticating users
                permitAll();
    }
}
