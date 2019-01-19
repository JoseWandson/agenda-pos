package br.com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**", "/resources/**").permitAll().antMatchers("/contatos")
				.hasRole("ADMIN").and().formLogin().loginPage("/login").permitAll().and().exceptionHandling()
				.accessDeniedPage("/403").and().logout().logoutSuccessUrl("/login?logout").permitAll();
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}
