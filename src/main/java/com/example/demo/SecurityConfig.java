package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.impl.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/home","/index","/","/css/**", "/js/**").permitAll()
		.antMatchers("/home").hasAnyRole("USER","ADMIN")
		.antMatchers("/all").hasAnyRole("ADMIN")
		.antMatchers("/api/v1/home/create").hasAnyRole("ADMIN")
		.antMatchers("/api/v1/home/save").hasAnyRole("ADMIN")
		.antMatchers("/api/v1/home/save/**").hasAnyRole("ADMIN")
		.antMatchers("/api/v1/home/delete/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
		
	}
	
	@Autowired
	public void configurerSecurityGobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(bcrypt)
		.usersByUsernameQuery("SELECT nombre, clave, rol FROM usuario WHERE nombre=?")
		.authoritiesByUsernameQuery("SELECT u.nombre, r.rol FROM usuario u INNER JOIN rol r ON u.rol=r.id WHERE u.nombre=?");
		
		
	}
	
	
	
	//-------------------------------------------------------------------------------//
	//@Override
	//protected void  configure(AuthenticationManagerBuilder auth)
	//throws Exception {
		
	//auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
		
		//auth
		//.inMemoryAuthentication()
		//.withUser("user")
			//.password("password")
			//.roles("ADMIN")
			//.and()
		//.withUser("admin")
			//.password("admin")
			//.roles("USER", "ADMIN");
	//}
	
	
	//@Override
	//protected void configure(HttpSecurity http) throws Exception {
		//http
			//.authorizeRequests().antMatchers("/","/api/v1/home","/home", "/css/**", "/js/**").permitAll()
			//.anyRequest()
			//.authenticated()
			//.and()
			//.httpBasic();
		//.authorizeRequests().antMatchers("/","/api/v1/home","/home", "/css/**", "/js/**").permitAll()
		//.anyRequest()
		//.antMatchers("/index/").hasAnyRole("USER")
		//.antMatchers("/").hasAnyRole("USER")
		//.authenticated()
		//.antMatchers("/index/").hasAnyRole("ADMIN")
		//.antMatchers("/").hasAnyRole("ADMIN")
		//.antMatchers("/index/create").hasAnyRole("ADMIN")
		//.antMatchers("/index/save").hasAnyRole("ADMIN")
		//.antMatchers("/index/save/**").hasAnyRole("ADMIN")
		//.antMatchers("/delete/**").hasAnyRole("ADMIN")
		//.anyRequest().authenticated()
		//.and()
		//.formLogin().permitAll()
		//.and()
		//.logout().permitAll();
	//}
	
	
}
