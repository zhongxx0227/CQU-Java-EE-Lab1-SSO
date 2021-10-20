package app1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class showSource {
    @PostMapping(value = "showSource")
    public String showSource(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String newToken = request.getParameter("newToken");
        String username = request.getParameter("username");
        if(!newToken.equals("-1"))
        {
            Cookie cookie =new Cookie("SSO"+username,newToken);
            //设置cookie一个月后过期
            cookie.setMaxAge(3600*24*30);
            response.addCookie(cookie);
        }
        String height = request.getParameter("sourceType");
        model.addAttribute("source",height);
        model.addAttribute("username",username);
        return "showSource";
    }
}
