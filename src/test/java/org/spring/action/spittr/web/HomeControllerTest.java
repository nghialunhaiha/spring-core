package org.spring.action.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class HomeControllerTest extends BaseControllerTest {

    @Test
    public void testHomePage() throws Exception {
        super.get("/spittles").andExpect(view("spittles_view")).andExpect(model().attributeExists("spittleList"));
    }

    @Test
    public void testHomePageCicularPath() throws Exception {
        HomeController controller = new HomeController();

        @SuppressWarnings("unused")
        MockMvc mockMvc = super.mockController(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        // using this mockMvc to perform
    }
}
