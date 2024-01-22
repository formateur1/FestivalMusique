package com.inti.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfiguration {
	
	@Autowired
	SecurityUserDetailsService suds;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/inscription", "/css/**", "/js/**").permitAll();
					auth.requestMatchers("/soliste/**").hasRole("USER");
					auth.anyRequest().authenticated();
				})
				.formLogin(form -> form.loginPage("/login").permitAll())
				.build();				
	}
	
	
	@Bean
	UserDetailsService getUsers()
	{
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build();
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN").build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = 
				http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(suds).passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
		
	}

}
