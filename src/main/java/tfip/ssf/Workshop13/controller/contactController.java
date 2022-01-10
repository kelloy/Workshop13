package tfip.ssf.Workshop13.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tfip.ssf.Workshop13.helper.helper;
import tfip.ssf.Workshop13.model.contact;

@Controller

public class contactController {


    @GetMapping("/contact")
    public String showContactForm(Model model){
        contact contact = new contact();
        model.addAttribute("contactObj", contact);
        return "contact";
    }

    
    @RequestMapping("/contact")
    @PostMapping(consumes = "application/x-www-form-urlencoded",
    produces = "text/html")
    public String createUser(@ModelAttribute contact contact, Model model) throws IOException{
        String name = contact.getName();
        String phone = Integer.toString(contact.getPhone());
        String email = contact.getEmail();
        String hexId = contact.getHexID();
        List<String> details = new ArrayList<>();
        details.add(name);
        details.add(email);
        details.add(phone);
        details.add(hexId);
        if(helper.createFile(hexId, details)){
            String message = "201";
            model.addAttribute("message",message);
        }
        model.addAttribute("details",details);
        return "status";
        }


        @GetMapping("/contact/{id}")
        public String displaydetails(@ModelAttribute contact contact, Model model,@PathVariable String id){
            List<String> detailList = new ArrayList<>();
            detailList = helper.readFiles(id);
            contact = new contact();
            String name = detailList.get(0);
            String email = detailList.get(1);
            String phone = detailList.get(2);
            model.addAttribute("name",name);
            model.addAttribute("email",email);
            model.addAttribute("phone",phone);
            return "result";

            
            

            
        }


   






    }
    

