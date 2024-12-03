package vttp.batch5.ssf.day19_contactbook.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import vttp.batch5.ssf.day19_contactbook.models.Contact;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping("/form")
    public ModelAndView getContactForm() {

        ModelAndView mav = new ModelAndView();

        Contact contact = new Contact();

        mav.addObject("contact", contact);
        mav.setViewName("contact-form");

        return mav;
    }

    @PostMapping("/save")
    public ModelAndView postContactForm(Contact contact, HttpSession sess) {
        ModelAndView mav = new ModelAndView();

        List<Contact> contacts = (List<Contact>) sess.getAttribute("contacts");

        if (contacts == null) {
            contacts = new ArrayList<>();
        }

        contacts.add(contact);

        sess.setAttribute("contacts", contacts);
        mav.setViewName("redirect:/contact/all");
        
        return mav;
    }

    @GetMapping("/all")
    public ModelAndView getAllContacts(HttpSession sess) {

        ModelAndView mav = new ModelAndView();

        List<Contact> contacts = (List<Contact>) sess.getAttribute("contacts");

        if (contacts == null) {
            contacts = new ArrayList<>();
        }

        mav.addObject("contacts", contacts);
        mav.setViewName("list-contacts");

        return mav;
    }
 }
