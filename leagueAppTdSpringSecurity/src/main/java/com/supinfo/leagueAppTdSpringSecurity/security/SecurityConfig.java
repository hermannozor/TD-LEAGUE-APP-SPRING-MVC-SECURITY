package com.supinfo.leagueAppTdSpringSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * Partie Spring security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/*
	 * Permet de stocker le mot de pass sous forme de hash en mémoire au lieu que ce soit visible
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
	
	//Définition de ma liste d'users et de rôles à partir du inMemoryAuthentification (Authentification des users en mémoire
	/*
	 * noop = No password encoder
	 */
	@Bean
	public InMemoryUserDetailsManager  inMemoryUserDetailsManager() {
		return new InMemoryUserDetailsManager(
				User.withUsername("user").password("{noop}1234").roles("USER").build(),
				User.withUsername("user1").password("{noop}1234").roles("USER").build(),
				User.withUsername("user2").password(passwordEncoder().encode("1234")).roles("USER").build(),
				User.withUsername("admin").password(passwordEncoder().encode("1234")).roles("USER","ADMIN").build());
		
	}
	
	
	//Utilisation de l'annotation 'Bean' pour que la méthode s'exécute au démarrage
	@Bean
	public SecurityFilterChain securityFilerChain(HttpSecurity httpSecurity) throws Exception {
		//Je dis à Spring Security que je souhaiterais que toutes les requêtes nécessitent une authentification
		httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		//Je demande à spring security d'utiliser un formulaire d'authentiification
		httpSecurity.formLogin();
		return httpSecurity.build();
		
	}

}
