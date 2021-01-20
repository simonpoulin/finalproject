package fpt.java.finalproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import fpt.java.finalproject.services.GuestDetailsService;

@EnableWebSecurity
@Configuration
public class GuestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GuestDetailsService guestDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(guestDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/user/**")
                .authorizeRequests()
                    .antMatchers("/user/register").permitAll()
                    .antMatchers("/user/register/save").permitAll()
                    .antMatchers("/user/forgetpassword").permitAll()
                    .antMatchers("/user/recover").permitAll()
					// ROLE Employee
                    .and()
                .formLogin()
                    .loginPage("/user/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successForwardUrl("/user/index")
                    .defaultSuccessUrl("/user/index")
                    .failureUrl("/user/login?error")
                    .and()
                .exceptionHandling()
					.accessDeniedPage("/user/403")
					.and()
				.logout()
					.logoutUrl("/user/logout")
					.logoutSuccessUrl("/user/login");
    }

}
