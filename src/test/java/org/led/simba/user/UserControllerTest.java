package org.led.simba.user;

import org.junit.Test;
import org.led.simba.BaseControllerTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest extends BaseControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void getUserByNameAndId() throws Exception {
//        name","addr
        String userName = "name2";
        String address = "name2";
        mockMvc.perform(MockMvcRequestBuilders.get("/mgmt/?name=" + userName + "&?addr=" + address)
                );
    }
}
