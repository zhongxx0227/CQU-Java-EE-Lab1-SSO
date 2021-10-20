package server.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.Token;
import server.demo.domain.User;
import server.demo.domain.User.*;
import server.demo.domain.security;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkCode {
    @PostMapping(value = "checkCode")
    public String chekCode(HttpServletRequest request, Model model)
    {

        String code = security.decrypt(request.getParameter("code"));
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String checkUsername = User.userMap.get(username).getUsername();
        if(code.equals(checkUsername))
        {
            String token = Token.createToken(username);
            model.addAttribute("token",token);
            model.addAttribute("redirectUrl",redirectUrl);
            model.addAttribute("username",username);
            return "sendToken";
        }
        return "redirect://localhost:8888/portal";
    }
}
