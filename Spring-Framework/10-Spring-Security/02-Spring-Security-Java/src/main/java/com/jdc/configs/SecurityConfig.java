package com.jdc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		
		https.authorizeHttpRequests(req -> {
			req.requestMatchers("/", "/home").permitAll();
			req.requestMatchers("/admin/**").hasAuthority("Admin");
			req.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
		});
		
		https.formLogin(form -> {});
		https.logout(logout -> {});
		
		return https.build();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		return new InMemoryUserDetailsManager(
				User.withUsername("admin").authorities("Admin").password("{noop}admin").build(),
				User.withUsername("member").authorities("Member").password("{noop}member").build()
				);
	}

}
