package org.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
// scans project for Spring components
@ComponentScan(basePackages = {BaseTest.BASE_PACKAGE}, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@PropertySource(value = {"classpath:application.properties"})
@Import(value = {DataSourceConfig.class})
public class BaseContextConfiguration {


}
