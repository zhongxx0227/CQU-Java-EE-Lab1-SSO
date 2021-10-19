package server.demo.domain;

public class msg {
    public int code;
    public String m;
    public msg(int code,String m)
    {
        this.code = code;
        this.m = m;
    }
    public msg()
    {
        this.code = 0;
        this.m = "Exception";
    }
}
