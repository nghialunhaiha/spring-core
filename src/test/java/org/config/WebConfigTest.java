package org.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@WebAppConfiguration
@EnableWebMvc
@ComponentScan(basePackages = {BaseTest.BASE_PACKAGE})
public class WebConfigTest extends WebMvcConfigurationSupport {

}
