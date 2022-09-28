package com.example.planergram.config;

import com.example.planergram.config.jwt.JwtAuthenticationFilter;
import com.example.planergram.config.jwt.JwtAuthorizationFilter;
import com.example.planergram.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter) // @CrossOrigin(인증x), 시큐리티 필터에 등록 인증(o)
                .formLogin()
                .usernameParameter("username").disable()
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
                .authorizeRequests()
                .antMatchers("/api/auth/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("api/admin/auth/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();
    }
}
