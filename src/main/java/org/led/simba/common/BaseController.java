package org.led.simba.common;

import org.led.simba.product.ProductConstant;
import org.led.simba.user.UserConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by NTQ-Admin on 23-09-2016.
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/mgmt/", method = RequestMethod.GET)
    public String getIndexPage() {
        return UserConstants.USER_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = {"/home", "/home/"}, method = RequestMethod.GET)
    public String getHomePage() {
        return UserConstants.HOME;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return UserConstants.INDEX;
    }

    @RequestMapping(value = "/prd-list/", method = RequestMethod.GET)
    public String getPrdList() {
        return ProductConstant.PRODUCT_LIST;
    }

    @RequestMapping(value = "/item/100", method = RequestMethod.GET)
    public String getPrdById() {
        return ProductConstant.PRD_DETAIL;
    }

    @RequestMapping(value = {"/mgmt/prd", "/mgmt/prd/"}, method = RequestMethod.GET)
    public String getProductManagementPage() {
        return ProductConstant.PRD_MGMT;
    }
}
