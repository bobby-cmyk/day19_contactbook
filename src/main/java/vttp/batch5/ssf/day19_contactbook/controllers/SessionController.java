package vttp.batch5.ssf.day19_contactbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {
    
    @GetMapping("/clear")
    public ModelAndView clearSession(HttpSession sess) {
        ModelAndView mav = new ModelAndView();

        sess.invalidate();

        mav.setViewName("redirect:/index.html");
        
        return mav;
    }
}
