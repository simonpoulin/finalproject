package fpt.java.finalproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import fpt.java.finalproject.services.EmployeeDetailsService;

@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/admin/**")
                .authorizeRequests()
                    .antMatchers("/admin/register").permitAll()
                    .antMatchers("/admin/register/save").permitAll()
                    .antMatchers("/admin/forgetpassword").permitAll()
                    .antMatchers("/admin/recover").permitAll()

					// ROLE Employee
					.antMatchers("/admin/dashboard").hasRole("EMPLOYEE")
                    .antMatchers("/admin/shops").hasRole("EMPLOYEE")
                    .antMatchers("/admin/brands").hasRole("EMPLOYEE")
                    .antMatchers("/admin/categories").hasRole("EMPLOYEE")
                    .antMatchers("/admin/shoppacks").hasRole("EMPLOYEE")
                    .antMatchers("/admin/products").hasRole("EMPLOYEE")
                    
                    // ROLE manager
                    .antMatchers("/admin/statistical").hasRole("MANAGER")
                    
                    .antMatchers("/admin/categories/add").hasRole("MANAGER")
                    .antMatchers("/admin/categories/save").hasRole("MANAGER")
                    .antMatchers("/admin/categories/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/categories/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/categories/**").hasRole("MANAGER")

                    .antMatchers("/admin/brands/add").hasRole("MANAGER")
                    .antMatchers("/admin/brands/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/brands/save").hasRole("MANAGER")
                    .antMatchers("/admin/brands/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/brands/**").hasRole("MANAGER")
                   
                    .antMatchers("/admin/products/add").hasRole("MANAGER")
                    .antMatchers("/admin/products/save").hasRole("MANAGER")
                    .antMatchers("/admin/products/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/products/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/products/**").hasRole("MANAGER")

                    .antMatchers("/admin/shops/add").hasRole("MANAGER")
                    .antMatchers("/admin/shops/save").hasRole("MANAGER")
                    .antMatchers("/admin/shops/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/shops/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/shops/**").hasRole("MANAGER")

                    .antMatchers("/admin/shoppacks/add").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/save").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/**").hasRole("MANAGER")

                    .antMatchers("/admin/users/").hasRole("MANAGER")
                    .antMatchers("/admin/users/add").hasRole("MANAGER")
                    .antMatchers("/admin/users/save").hasRole("MANAGER")
                    .antMatchers("/admin/users/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/users/delete/**").hasRole("MANAGER")
                    .antMatchers("/admin/users/**").hasRole("MANAGER")

                    // ROlE admin
                    .antMatchers("/admin/employees").hasRole("ADMIN")
                    .antMatchers("/admin/employees/add").hasRole("ADMIN")
                    .antMatchers("/admin/employees/save").hasRole("ADMIN")
                    .antMatchers("/admin/employees/edit/**").hasRole("ADMIN")
                    .antMatchers("/admin/employees/delete/**").hasRole("ADMIN")
                    .antMatchers("/admin/employees/**").hasRole("ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/admin/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successForwardUrl("/admin/dashboard")
                    .defaultSuccessUrl("/admin/dashboard")
                    .failureUrl("/admin/login?error")
                    .and()
                .exceptionHandling()
					.accessDeniedPage("/admin/403")
					.and()
				.logout()
					.logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/login");
    }

}
