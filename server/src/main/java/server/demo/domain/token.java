package server.demo.domain;

import static server.demo.domain.User.userMap;

public class token {
    public static String createToken(String username)
    {
        return "username";
    }
    public static msg checkToken(String username,String token)
    {
        User temp = userMap.get(username);
        if(temp==null)
        {
            return new msg(003,"token错误，不存在该用户名！");
        }
        msg ans = new msg();
        if(temp.getToken().equals(token))
        {
            ans.code = 102;
            ans.m = "token匹配成功！";
        }
        else
        {
            ans.code = 004;
            ans.m = "token不匹配！";
        }
        return ans;
    }
}
