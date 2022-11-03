package com.example.routing_adddel.controller;

import com.example.routing_adddel.DTO.ModuleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class APIController {

    ArrayList<ModuleForm> modules = new ArrayList<ModuleForm>();

    //Displaying the sending form
    @RequestMapping(path = "/send")
    public String sendElements(){
        return "redirect:Sending.html";
    }

    //Adding data and displaying in the receiving form
    @RequestMapping(path = "/addPost", method = RequestMethod.POST)
    public ModelAndView addElements(ModuleForm module){
        ModelAndView modelAndView = new ModelAndView();
        try {
            modules.add(module);
            modelAndView.addObject("modules", modules);
            modelAndView.setViewName("Receiving");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return modelAndView;
    }
}
