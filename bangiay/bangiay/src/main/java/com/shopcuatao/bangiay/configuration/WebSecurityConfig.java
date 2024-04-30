package com.shopcuatao.bangiay.configuration;

import com.shopcuatao.bangiay.filters.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;
    @Value("${api.prefix}")
    private String api;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request ->{
                            request.requestMatchers(HttpMethod.POST,String.format("%s/user/**",api))
                                    .permitAll()
                                    .requestMatchers(HttpMethod.GET,String.format("%s/color/**",api)).permitAll()
                                    .requestMatchers(HttpMethod.GET,String.format("%s/test/**",api)).permitAll()
                                    .requestMatchers(HttpMethod.POST,String.format("%s/color/**",api)).hasAnyRole("ADMIN")
                                    .requestMatchers(HttpMethod.PUT,String.format("%s/color/**",api)).hasAnyRole("ADMIN")
                                    .requestMatchers(HttpMethod.DELETE,String.format("%s/color/**",api)).hasAnyRole("ADMIN")

                                    .requestMatchers(HttpMethod.GET,String.format("%s/brand/**",api)).permitAll()
                                    .requestMatchers(HttpMethod.GET,String.format("%s/size/**",api)).permitAll()
                                    .requestMatchers(HttpMethod.POST,String.format("%s/size/**",api)).hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.GET,String.format("%s/xuatxu/**",api)).permitAll()
                                    .requestMatchers(HttpMethod.GET,String.format("%s/productDetail/**",api)).permitAll()
                                    .anyRequest()
                                    .authenticated();
                        }
                        );
        return http.build();
    }
}
