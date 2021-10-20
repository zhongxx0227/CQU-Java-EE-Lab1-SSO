package server.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.Token;
import server.demo.domain.User;
import server.demo.domain.msg;
import server.demo.domain.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginPwd {
    @PostMapping(value = "loginPwd")
    public String loginPwd(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String redirectUrl = request.getParameter("redirectUrl");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        msg ans = User.checkPwd(username,pwd);
        if(ans.code==101)
        {
              String code = username;
              model.addAttribute("code", security.encrypt(code));
              model.addAttribute("username",username);
              model.addAttribute("redirectUrl",redirectUrl);
              return "sendCode";
//            String token = Token.createToken(username);
//            Cookie cookie = new Cookie("SSO"+username,token);
//            cookie.setMaxAge(3600*720);
//            response.addCookie(cookie);
//            model.addAttribute("redirectUrl",redirectUrl);
//            model.addAttribute("username",username);
//            return "getSource";
        }
        model.addAttribute("exceptionMsg",ans.m);
        return "loginError";
    }
}
