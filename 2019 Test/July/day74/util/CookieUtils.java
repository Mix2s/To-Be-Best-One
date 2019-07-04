package util;

import javax.servlet.http.Cookie;

/**
 * 获取指定Cookie工具类
 */
public class CookieUtils {
    public static Cookie getCookieByName(String name, Cookie[] cookies) {
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
