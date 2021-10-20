package server.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginByPwd {
    @GetMapping(value = "loginByPwd")
    public String pwd(String redirectUrl, Model model)
    {
        model.addAttribute("redirectUrl",redirectUrl);
        return "loginByPwd";
    }
}
