package fpt.java.finalproject.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer  {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/icons/**","/js/**","/fonts/**","/images/**").addResourceLocations("classpath:/static/assets/css/", "classpath:/static/assets/icons/","classpath:/static/assets/js/","classpath:/static/assets/fonts/","classpath:/static/assets/images/");
    }

}
