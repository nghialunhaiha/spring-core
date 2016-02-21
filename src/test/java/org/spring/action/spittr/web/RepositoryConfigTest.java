package org.spring.action.spittr.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.spring.action.spitter.data" })
public class RepositoryConfigTest {

}
