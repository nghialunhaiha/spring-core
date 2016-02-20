package org.spring.action.spittr.web;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jp.co.systena.cloudstep.canbus.infrastructure.json.JsonUtils;

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

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public ResultActions put(String uri, Object object) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtils.toJson(object)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultActions post(String uri, Object object) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtils.toJson(object)));
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

    public ResultMatcher assertView(String expectedViewName) {
        return MockMvcResultMatchers.view().name(expectedViewName);
    }
}
