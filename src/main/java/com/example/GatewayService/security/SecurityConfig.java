package com.example.GatewayService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
//                .authorizeRequests().antMatchers("/login","/register").permitAll()
//                .and()
//                .cors() // Ngăn chặn request từ một domain khác
//                .and()
//                .authorizeRequests().antMatchers("/checkdaotao").hasAnyAuthority("DT")
//                .and()
//                .authorizeRequests().antMatchers("/giao-vien").hasAnyAuthority("GV")
//                .and()
//                .authorizeRequests().antMatchers("/hoc-sinh").hasAnyAuthority("HS")
//                .and()
//                .authorizeRequests().antMatchers("/demo2").hasAnyAuthority("GV")
//                .and()
//                .authorizeRequests().antMatchers("/tin-tuc/**").hasAnyAuthority("GV","HS","DT","BGH")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
    }
}
