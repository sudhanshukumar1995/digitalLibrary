package com.project.digitalLibrary.zzzz_configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.digitalLibrary.dddd_services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserService userService;

	@Autowired
	public SecurityConfig(UserService userService) {
		this.userService = userService;
	}

	/*
	 * Request ---> Filters ----> RestControllers
	 * 
	 * We can define our own customized filters @EnableWebSecurity. Multiple filters
	 * are implemented in chained order. Together they form a filter chain. One by
	 * one filters are applied
	 */

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity
	 * httpsecurity) throws Exception { return httpsecurity.build(); }
	 * 
	 * The above means we are doing nothing. And just returning it means that
	 * security has not been applied even
	 */

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
		return httpsecurity.csrf(customizer -> customizer.disable()) // is how to disable csrf
				.authorizeHttpRequests(request -> request
						.requestMatchers("/users/add").permitAll()
				.anyRequest().authenticated()) // directly authentication of // any HTTP Methods									
				
				.formLogin(Customizer.withDefaults()) // when login for UI Form Page
				.httpBasic(Customizer.withDefaults()) // when login for Rest API/Postman Client
				.oauth2Login(Customizer.withDefaults())
				.build();
	}

	/*
	 * UserDetailsService is a functional interface that is used create credentials
	 * for multiple hardcoded users. And not only one
	 */
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails u1 = User
//				.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("x123")
//				.roles("ADMIN")
//				.build();
//		UserDetails u2 = User
//				.withDefaultPasswordEncoder()
//				.username("hello")
//				.password("x123")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(u1, u2); //this class already implements the userdetailsservice interface. 
//		//we are leveraging one of its constructor to pass the hardcoded values
//	}

	// Below is the way of using username and password from the rows stored in
	// database
	/*
	 * I can pass the userservice instance. Because I have already implemented the
	 * UserDetails interface in UserService
	 * 
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { try { UserModel userModel =
	 * this.getUserByEmail(username); return new UserPrincipal(userModel); } catch
	 * (ResourceNotFoundException e) { throw new
	 * UsernameNotFoundException(e.getMessage()); } }
	 */
	
//	@Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        provider.setUserDetailsService(this.userService);
//        return provider;
//    }

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //ecrypts the password with hashing strength of 12. More hashing strength, more security but takes time to decrypt
		provider.setUserDetailsService(userService);
		return provider;
	}
}