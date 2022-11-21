///*
//package br.atos.zoologico.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig {
//
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//
//				.csrf()
//				.disable()
//				.authorizeRequests()
//				//.antMatchers(HttpMethod.GET, "/**").permitAll()
//				.antMatchers(HttpMethod.POST,"/cuidador/cadastrar").hasRole("ADMIN")
//				.antMatchers(HttpMethod.POST,"/jaula/cadastrar").hasRole("ADMIN")
//				.antMatchers(HttpMethod.POST,"/animal/cadastrar").hasRole("ADMIN")
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/anonymous*").anonymous()
//				.antMatchers("/login*").permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin().passwordParameter("password").usernameParameter("userName")
//				.loginPage("/login")
//				.loginProcessingUrl("/process-login")
//				.defaultSuccessUrl("/", true)
//				.failureUrl("/login-error")
//				//
//				.and()
//				.logout()
//				.logoutSuccessUrl("/login")
//				.logoutUrl("/logout")
//				.deleteCookies("JSESSIONID");
//		return http.build();
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//
//
//}
//*/
