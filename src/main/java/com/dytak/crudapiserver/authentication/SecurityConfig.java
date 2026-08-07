package com.dytak.crudapiserver.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //CustomUserDetailService customUserDetailService = new CustomUserDetailService();

    AuthenticationFilter authenticationFilter = new AuthenticationFilter();
    http
        //.csrf(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        //.httpBasic(Customizer.withDefaults())
        .httpBasic(AbstractHttpConfigurer::disable)
        //  .formLogin(Customizer.withDefaults())
        .addFilterAfter(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    //     .addFilter(authenticationFilter)
    //      .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
    //authorizeHttprequest의 requestMatchers를 통해 접근 가능한 api를 분기가능
    //        .authorizeHttpRequests(authorize -> authorize
    //                 .anyRequest().authenticated());
    return http.build();
  }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
}