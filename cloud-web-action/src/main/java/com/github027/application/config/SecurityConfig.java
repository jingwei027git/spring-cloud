package com.github027.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github027.domain.security.SecurityUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityUserService sysUserService;


	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(sysUserService);

		final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(sysUserService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		daoAuthenticationProvider.setPreAuthenticationChecks(userDetailsChecker());
		auth.authenticationProvider(daoAuthenticationProvider);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers("/dump", "/env", "/bus/env", "/heapdump", "/metrics", "/info", "/health", "/features", "/mappings", "/trace").permitAll() // actuator
            .antMatchers("/build/**", "/css/**", "/images/**", "/js/**", "/resources/**", "/vendors/**").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN") // reserved
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // reserved
            .antMatchers("/**").hasRole("USER")
            .anyRequest().authenticated()
        .and()
        	.formLogin()
            .loginPage("/login").defaultSuccessUrl("/dashboard", true)
            .permitAll()
        .and()
        	.logout()
            .permitAll();
	}

	@Bean
	protected UserDetailsChecker userDetailsChecker() {
		return userDetails -> {
			if (!userDetails.isEnabled()) {
				throw new DisabledException("User is not active");
			}
		};
	}
}
