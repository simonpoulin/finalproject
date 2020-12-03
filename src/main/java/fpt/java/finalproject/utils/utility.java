package fpt.java.finalproject.utils;

import javax.servlet.http.HttpServletRequest;

public class utility {
    public static String getSiteUrl(HttpServletRequest rs){
        String siteUrl=rs.getRequestURL().toString();
        return siteUrl.replace(rs.getServletPath(), "");
    }
}
