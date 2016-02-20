package org.spring.action.spittr.web;

import org.junit.Test;

public class HomeControllerTest extends BaseControllerTest{
    @Test
    public void testHomePage() throws Exception {
        super.get("/").andExpect(assertView("home"));

    }
    
}
