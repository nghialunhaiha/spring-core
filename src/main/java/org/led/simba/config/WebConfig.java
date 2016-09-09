package org.led.simba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // spring configuration on start up
@ComponentScan("org.spring")
@EnableWebMvc // enable mvc model web
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * Configure a JSP view resolver
     * 
     * >>>>>>>>>>>>>>>>>>>>>>>>talk more about view resolvers in chapter 6
     * 
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * Configure static content handling
     * 
     * asking DispatcherServlet to forward requests for static resources to the servlet container’s default servlet and
     * not to try to handle them itself.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
