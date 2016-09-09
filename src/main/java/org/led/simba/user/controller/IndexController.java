package org.led.simba.user.controller;

import org.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends BaseController{

    private static final String USER_MANAGEMENT_PAGE = "user-mgmt/UserManagement";
    private static final String HOME = "/home/home";
    private static final String INDEX = "/home/index";
    private static final String PRODUCT_LIST = "/prd-list-page/prd-list";
    private static final String PRD_DETAIL = "/prd-detail/prd-detail";

    @RequestMapping(value = "/mgmt/", method = RequestMethod.GET)
    public String getIndexPage() {
        return USER_MANAGEMENT_PAGE;
    }

    @RequestMapping(value = {"/home", "/home/"}, method = RequestMethod.GET)
    public String getHomePage(){
        return HOME;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(){
        return INDEX;
    }

    @RequestMapping(value = "/prd-list/", method = RequestMethod.GET)
    public String getPrdList(){
        return PRODUCT_LIST;
    }

    @RequestMapping(value = "/item/100", method = RequestMethod.GET)
    public String getPrdById() {
        return PRD_DETAIL;
    }

}