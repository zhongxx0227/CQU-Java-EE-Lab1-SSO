package server.demo.domain;

public class security {
    public static String encrypt(String target)
    {
        StringBuilder str = new StringBuilder(target);
        return str.reverse().substring(0);
    }
    public static String decrypt(String target)
    {
        StringBuilder str = new StringBuilder(target);
        return str.reverse().substring(0);
    }
}
