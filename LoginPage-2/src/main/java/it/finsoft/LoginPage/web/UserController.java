package it.finsoft.LoginPage.web;

import it.finsoft.LoginPage.model.User;
import it.finsoft.LoginPage.service.SecurityService;
import it.finsoft.LoginPage.service.UserService;
import it.finsoft.LoginPage.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registration(Model model) {
        
    	model.addAttribute("userForm", new User());

        return "registration";
    }
    
    @RequestMapping(value = "registration", method = RequestMethod.POST)//this regestiration is called by jsp because u pushed submit buttom
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	//u filled info of new user in reg. jsp and now by pushing submit buttom
    	// u r sending that information inside userform to uservalidation
        userValidator.validate(userForm, bindingResult);//user validation checks if the info is correct 

        if (bindingResult.hasErrors()) {//if info has error ,it returns u to same registration page to redo the registration steps
            return "/registration";
        }

        userService.save(userForm);//if u correctly filled info ,userservice saves new user inside database

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        //this securityservice is spring internal method that ,if u create a new user successivel,it logs u in automatically
        //return "redirect:/welcome";
        return "welcome";//when u have POST method u need to do redirect 
        //because the GET method is to show smthng but POST is not to show smthng is to elaborate or sending data and do some operations so u need to redirect
        //to a GET method (wrong! I deleted redirect and still it works
    }

    @RequestMapping(value = "/AddNewUser", method = RequestMethod.GET)
    public String addnewuser(Model model) {
        model.addAttribute("userForm", new User());

        return "addnewuser";
    }
    
    @RequestMapping(value = "/AddNewUser", method = RequestMethod.POST)
    public String addnewuser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {													
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addnewuser";
        }
        userService.save(userForm);
        return "welcome";
    }
 
    
  
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
         model.addAttribute("error", "Your username and password is invalid.");
 
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
             
        return "login";
    }


    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}