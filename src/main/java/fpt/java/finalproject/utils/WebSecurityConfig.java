package fpt.java.finalproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import fpt.java.finalproject.services.EmployeeDetailsService;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeDetailsService).passwordEncoder(passwordEncoder());
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
                    .antMatchers("/admin/categories/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/categories/**").hasRole("MANAGER")

                    .antMatchers("/admin/brands/add").hasRole("MANAGER")
                    .antMatchers("/admin/brands/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/brands/save").hasRole("MANAGER")
                    .antMatchers("/admin/brands/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/brands/**").hasRole("MANAGER")
                   
                    .antMatchers("/admin/find/**").hasRole("MANAGER")

                    .antMatchers("/admin/products/add").hasRole("MANAGER")
                    .antMatchers("/admin/products/save").hasRole("MANAGER")
                    .antMatchers("/admin/products/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/products/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/products/**").hasRole("MANAGER")

                    .antMatchers("/admin/shops/add").hasRole("MANAGER")
                    .antMatchers("/admin/shops/save").hasRole("MANAGER")
                    .antMatchers("/admin/shops/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/shops/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/shops/**").hasRole("MANAGER")

                    .antMatchers("/admin/shoppacks/add").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/save").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/shoppacks/**").hasRole("MANAGER")

                    .antMatchers("/admin/users/").hasRole("MANAGER")
                    .antMatchers("/admin/users/add").hasRole("MANAGER")
                    .antMatchers("/admin/users/save").hasRole("MANAGER")
                    .antMatchers("/admin/users/edit/**").hasRole("MANAGER")
                    .antMatchers("/admin/users/del/**").hasRole("MANAGER")
                    .antMatchers("/admin/users/**").hasRole("MANAGER")

                    // ROlE admin
                    .antMatchers("/admin/employees").hasRole("ADMIN")
                    .antMatchers("/admin/employees/add").hasRole("ADMIN")
                    .antMatchers("/admin/employees/save").hasRole("ADMIN")
                    .antMatchers("/admin/employees/edit/**").hasRole("ADMIN")
                    .antMatchers("/admin/employees/del/**").hasRole("ADMIN")
                    .antMatchers("/admin/employees/**").hasRole("ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/admin/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
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

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
    
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec, LayoutDialect layout) {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(sec); // Enable use of "sec"
        templateEngine.addDialect(layout);
        return templateEngine;
    }

}
