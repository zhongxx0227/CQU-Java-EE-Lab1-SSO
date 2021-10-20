package app1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class getCode {
    @PostMapping(value = "getCode")
    public String getCode(HttpServletRequest request, Model model)
    {
        String username = request.getParameter("username");
        String code = request.getParameter("code");
        String redirectUrl = "http://localhost:8081/getToken";
        model.addAttribute("username",username);
        model.addAttribute("code",code);
        model.addAttribute("redirectUrl",redirectUrl);
        return "sendCode";
    }
}
