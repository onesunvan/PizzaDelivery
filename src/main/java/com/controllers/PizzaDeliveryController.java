package com.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ivan
 */
@Controller
public class PizzaDeliveryController /*implements ApplicationContextAware*/ {
    
    @Autowired
    private ApplicationContext context;
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    @ResponseBody
    public String enterToPizzaService() {
        StringBuilder sb = new StringBuilder();
        for (String s : context.getBeanDefinitionNames()) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
    
//    @Override
//    public void setApplicationContext(ApplicationContext ac) throws BeansException {
//        context = ac;
//    }
}
