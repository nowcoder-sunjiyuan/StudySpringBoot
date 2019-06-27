/**
 * 
 */
package com.example.netdata.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 13795
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login.html");
		registry.addViewController("/").setViewName("/login.html");
		registry.addViewController("/index").setViewName("/login.html");
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 *//*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		 super.addResourceHandlers(registry);
		
	}*/
	
}
