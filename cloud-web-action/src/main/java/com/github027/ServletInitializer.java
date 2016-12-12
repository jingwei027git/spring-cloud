package com.github027;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Tomcat launch entry-point
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
        final SpringApplicationBuilder application)
    {
        return application.sources(WebActionApplication.class);
    }

}
