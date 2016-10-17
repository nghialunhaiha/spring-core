package org.demo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.config.BaseTest;
import org.core.json.JsonUTils;
import org.core.json.JsonUtils_BackUp;
import org.junit.Assert;
import org.junit.Test;
import org.led.simba.product.ProductItem;
import org.led.simba.product.service.ProductService;
import org.led.simba.user.User;
import org.led.simba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    public void insertUser() {
        User user1 = new User();
        //  user1.setId(1);
        user1.setEmail("nasdghia@gmai.com");
        user1.setAddress("ajsdfasd");
        user1.setUsername("userName");

        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user1);
        userService.saveUser(user1);
        printUsers();

        User userCreated = userService.findById(1);
        User user2 = userService.findById(2);
        userCreated.setAddress("Hai Ha Village, Hai Hau distric, Nam Dinh province.");
        user2.setAddress("Hai Ha Village, Hai Hau distric, Nam Dinh province.");
        userCreated.setEmail("tuannghiatoregister@gmail.com");
        user2.setEmail("tuannghiatoregister@gmail.com");
        userService.updateUser(userCreated);
        userService.updateUser(user2);
        System.out.println(JsonUTils.toJson(userService.findById(1)));

        userService.deleteUserById(1);
    }

    private void printUsers() {
        System.out.println("\n============================");
        userService.findAllUsers().stream().forEach(System.out::println);
        System.out.println("============================\n");
    }

    @Test
    public void findByName() {
        User user1 = new User();
        user1.setEmail("nasdghia@gmai.com");
        user1.setAddress("ajsdfasd");
        user1.setUsername("userName");

        userService.saveUser(user1);

        user1.setUsername("name2");
        userService.saveUser(user1);
        user1.setUsername("name3");
        userService.saveUser(user1);
        user1.setUsername("name2");
        userService.saveUser(user1);

        List<User> users = userService.findByName("name2");
        Assert.assertEquals(2, users.get(0).getId());
        Assert.assertEquals(4, users.get(1).getId());


        List<User> users1 = userService.findByNameAndAddr("name2", "ajsdfasd");
        System.out.println(JsonUTils.toJson(user1));
    }


    @Test
    public void getKeyFromJson() {
        String jsonInput = "{\n" +
                "    \"product\" : {\n" +
                "        \"title\" : \"Led chiếu sáng 5050 \",\n" +
                "        \"rate\" : \"chưa có thông tin đánh giá\",\n" +
                "        \"feedBack\" : \"Chưa có phản hồi\",\n" +
                "        \"order\" : \"10000000\",\n" +
                "        \"shipmentInfo\" : \"Giao hàng trong ng\",\n" +
                "        \"price\" : \"123132\",\n" +
                "        \"discountPrice\" : \"12311\",\n" +
                "        \"deliveryTime\" : \"111111\",\n" +
                "        \"deliveryNote\" : \"GIao hàng trong giờ hành chính.\",\n" +
                "        \"availableStatus\" : \"còn hàng\",\n" +
                "        \"subType\" : \"LED_STRIP\",\n" +
                "        \"productDescriptions\" : \"\",\n" +
                "        \"colors\" : \"RED\",\n" +
                "        \"ledType\" : \"none\",\n" +
                "        \"colorTemp\" : \"none\",\n" +
                "        \"occasion\" : \"\",\n" +
                "        \"powerGeneration\" : \"\",\n" +
                "        \"ledsPerMeter\" : \"\",\n" +
                "        \"averageLife\" : 0,\n" +
                "        \"waterProff\" : \"\",\n" +
                "        \"voltage\" : 0,\n" +
                "        \"colorTemperature\" : \"\",\n" +
                "        \"powerSource\" : \"none\",\n" +
                "        \"modelNumber\" : \"\"\n" +
                "    },\n" +
                "    \"userInfo\" : {\n" +
                "        \"loginId\" : \"nghialun\",\n" +
                "        \"token\" : \"123123123\"\n" +
                "    }\n" +
                "}";
        Map<String, String> req = JsonUTils.fromJson(jsonInput, Map.class);

        ProductItem pItem = JsonUTils.fromJson(JsonUTils.toJson(req.get("product")), ProductItem.class);
        productService.create(pItem);
        System.out.println(JsonUTils.toJson(pItem));
    }
}
