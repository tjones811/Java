package com.tjones.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CounterController {
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
        
        if (session.getAttribute("count") == null) {
        	int number = 0;
        	
            session.setAttribute("count",number);
            
           
        }
        
        else{

            
           int number =  (int) session.getAttribute("count");
           number++;
           session.setAttribute("count",number);
           
            
            
            
        } 
        
        
        
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String showCount(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow",currentCount);

        return "showCount.jsp";
    }
    
    @RequestMapping("/reset")
    public String resetCount(HttpSession session){
        session.setAttribute("count",0);

        return "index.jsp";
    } 

}
