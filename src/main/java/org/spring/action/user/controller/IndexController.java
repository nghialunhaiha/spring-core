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
        return "home";
    }

}