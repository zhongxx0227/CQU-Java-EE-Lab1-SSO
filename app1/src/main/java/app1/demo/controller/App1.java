package app1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class App1 {
    @RequestMapping(value = "app1")
    public String app1(HttpServletRequest request, Model model)
    {
        String username = "";
        String token ="";
        String redirectUrl = "http:localhost:8081/showSource";
        //在浏览器cookie中寻找带有该服务器特殊标记的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("SSO")) {
                    // 获取token
                    token = cookie.getValue();
                    // 获取用户名
                    username = cookie.getName().substring(3);
                    model.addAttribute("username",username);
                    model.addAttribute("token",token);
                    model.addAttribute("redirectUrl",redirectUrl);
                    model.addAttribute("sourceType","身高");
                    return "sendToken";
                    // 获取验证token的消息体
                }
            }
        }
        return "redirect:http://localhost:8080/loginByPwd?redirectUrl=http:localhost:8081/getCode";
    }
}
