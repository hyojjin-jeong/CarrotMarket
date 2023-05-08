package com.mysite.cm.config.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Configuration
	public class SpringSecurityConfig {
		
		@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.cors().disable().csrf().disable()
	                .authorizeHttpRequests(request -> request
	                        .requestMatchers("/CarrotMarket").permitAll()
	                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
	                        .anyRequest().authenticated()
	                )
	                .headers().frameOptions().disable()
	                .and()
	                .formLogin(login -> login
	                        .loginPage("/CarrotMarket/login")	
	                        .usernameParameter("email")	
	                        .passwordParameter("password")	
	                        .defaultSuccessUrl("/CarrotMarket", true)
	                        .permitAll()
	                )
	                .logout(withDefaults());

	        return http.build();
	    }
	}
}