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
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/assets/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/assets/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/assets/js/");
    }

}
