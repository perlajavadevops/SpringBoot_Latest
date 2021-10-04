package com.pgr.sb.web.SBFirstWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class BeanConfig {

	@Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix ("/WEB-INF/jsp/");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }
}
