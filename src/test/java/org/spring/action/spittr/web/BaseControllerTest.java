package org.spring.action.spittr.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import jp.co.systena.cloudstep.canbus.infrastructure.json.JsonUtils_BackUp;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class })
@ContextConfiguration(classes = { WebConfigTest.class, RepositoryConfigTest.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    private List<Object> controllers;

    @Before
    public void setup() {
        this.mockMvc = this.mockMvcUsingWebApplicationContext(webApplicationContext);
        // mockMvcUsingStandAlone(this.controllers);
    }

    private MockMvc mockMvcUsingWebApplicationContext(WebApplicationContext webApplicationContext) {
        return MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected StandaloneMockMvcBuilder mockControllers(List<Object> controllers) {
        return MockMvcBuilders.standaloneSetup(controllers);
    }

    protected StandaloneMockMvcBuilder mockController(Object controller) {
        return MockMvcBuilders.standaloneSetup(controller);
    }

    protected List<Object> addController(Object controller) {
        if (controllers == null) {
            this.controllers = new ArrayList<>();
        }
        this.controllers.add(controller);
        return this.controllers;
    }

    public ResultActions put(String uri, Object object) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtils_BackUp.toJson(object)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultActions post(String uri, Object object) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtils_BackUp.toJson(object)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultActions get(String uri) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.get(uri));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMatcher view(String expectedViewName) {
        return MockMvcResultMatchers.view().name(expectedViewName);
    }

    public ModelResultMatchers model() {
        return MockMvcResultMatchers.model();
    }
}
