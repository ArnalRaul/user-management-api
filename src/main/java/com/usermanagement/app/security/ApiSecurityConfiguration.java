package com.usermanagement.app.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public ApiSecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().cors().and().authorizeRequests()
	                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
	                .and().authorizeRequests().anyRequest().authenticated().and()
	                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
	                // this disables session creation on Spring Security
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
	
	 @Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
	    config.addAllowedHeader("Access-Control-Allow-Headers");
	    config.addAllowedHeader("Origin");
	    config.addAllowedHeader("Content-Type");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("GET");
	    config.addExposedHeader("authorization");
        config.setAllowCredentials(true);
	    source.registerCorsConfiguration("/**", config);
	    return source;
	  }
	 @Bean
	    public AuthenticationManager getAuthenticationManager() throws Exception {
	        return super.authenticationManagerBean();
	    }
}