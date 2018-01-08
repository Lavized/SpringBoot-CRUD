package com.crud.controllers;

import com.crud.model.AppUser;
import com.crud.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {



   private final AppUserService userService;

    public MainController(AppUserService userService) {
        this.userService = userService;
    }


    @RequestMapping({"","/","/index"})
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("hi","Hello friend");
        mv.addObject("list",userService.getAppUsers());
        return mv;
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") String id,@RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname){
        ModelAndView mv = new ModelAndView("redirect:/");

        AppUser user;

        if (!id.isEmpty()) {
            user = userService.findById(Long.valueOf(id));
        }
        else {
            user = new AppUser();
        }

        user.setFirstName(firstname);
        user.setLastName(lastname);
        userService.save(user);

        return mv;
    }


    @RequestMapping("/view/{id}")
    public ModelAndView doView(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("appUSER", userService.findById(Long.valueOf(id)));
        return mv;
    }


    @RequestMapping("/delete/{id}")
    public ModelAndView doDelete(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("redirect:/");
        userService.deleteById(Long.valueOf(id));
        return mv;
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView doEdit(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("appUSER", userService.findById(Long.valueOf(id)));
        return mv;
    }
}
