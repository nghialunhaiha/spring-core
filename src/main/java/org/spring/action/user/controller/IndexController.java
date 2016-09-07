package org.spring.action.user.controller;

import org.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends BaseController{

    @RequestMapping(value = "/management/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "UserManagement";
    }

    @RequestMapping(value = "/home/", method = RequestMethod.GET)
    public String getHomePage(){
        return "/home/home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(){
        return "/home/index";
    }

    @RequestMapping(value = "/test-list-prds/", method = RequestMethod.GET)
    public String getPrdCategoryPage(){
        return "products-category";
    }

    @RequestMapping(value = "/prd-list/", method = RequestMethod.GET)
    public String getPrdList(){
        return "/prd-list-page/prd-list";
    }
}