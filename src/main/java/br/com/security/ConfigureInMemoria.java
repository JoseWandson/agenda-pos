package br.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class ConfigureInMemoria {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("Wandson").password("{noop}123").roles("ADMIN").and()
				.withUser("maria").password("{noop}123").roles("USER");
	}

}
