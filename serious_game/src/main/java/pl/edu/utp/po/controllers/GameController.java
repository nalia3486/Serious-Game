package pl.edu.utp.po.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.utp.po.domain.Users;
import pl.edu.utp.po.services.RebusService;
import pl.edu.utp.po.services.RegisterService;

@Controller
public class GameController {

    @Autowired
    private RebusService rebusService;
    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegister(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String addToUsers(Users user) {
        registerService.addUser(user);
        return "redirect:/register";
    }

    @GetMapping("/pictures")
    public String showPictures(Model model) {
        return "pictures";
    }

    @GetMapping("/rebus")
    public String showRebuses(Model model) {
        model.addAttribute("rebus", rebusService.listofRebuses());
        return "rebus";
    }

    @GetMapping("/hangman")
    public String showHangman(Model model) {
        return "hangman";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }
}