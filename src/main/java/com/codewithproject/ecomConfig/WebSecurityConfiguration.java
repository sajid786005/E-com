package com.codewithproject.ecomConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.codewithproject.ecomFilters.JwtRequestFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
	
	private final JwtRequestFilter authFilter = new JwtRequestFilter();
	

	@Bean
	public SecurityFilterChain  securityFilterChain(HttpSecurity http) {
		try {
			return http
					.csrf()
					.disable()
					.authorizeHttpRequests()
					.requestMatchers( "/authenticate","/sing-up","/order/")
					.permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers( "/api/")
					.authenticated()
					.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
					.and()
					.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ; //RETURN NOT DECIDED
				
			}
			@Bean
			public PasswordEncoder passwordEncoder() { 
				return new BCryptPasswordEncoder();
			
			}
			@Bean
			public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
				return config.getAuthenticationManager();
}

}