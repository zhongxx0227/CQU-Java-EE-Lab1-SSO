/* @author 20194195王梓宇
    @time 2021.10.18
*/
package server.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import server.demo.domain.Token;
import server.demo.domain.User;
import server.demo.domain.msg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class loginT {
    @PostMapping(value = "loginByToken")
    public String loginHandle(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String redirectUrl = request.getParameter("redirectUrl");
        System.out.println("到达loginA！");
        String username = request.getParameter("username");
        String token = request.getParameter("token");
        String newToken = "-1";
        // 获取验证token的消息体
        msg ans = Token.checkToken(username,token);
        // 如果token匹配成功
        if(ans.code==102)
        {
            long now = System.currentTimeMillis();
            long tokenTime = Long.parseLong(token.substring(0, 13));
            // 如果token快要过期了，重新签发一个
            if(now-tokenTime>3600*1000*600)
            {
                newToken = Token.createToken(username);
            }
            String sourceType = request.getParameter("sourceType");
            model.addAttribute("redirectUrl",redirectUrl);
            model.addAttribute("username",username);
            model.addAttribute("newToken",newToken);
            model.addAttribute("source","身高");
            return "sendSource";
        }
        return "redirect:http://localhost:8888/portal";
//        String portal = "http://localhost:8888/portal";
//        model.addAttribute("redirectUrl",portal);
//        model.addAttribute("username",username);
//        return "loginByPwd";
    }
}
