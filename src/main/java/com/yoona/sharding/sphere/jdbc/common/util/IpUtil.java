package com.yoona.sharding.sphere.jdbc.common.util;


import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;


import static com.yoona.sharding.sphere.jdbc.common.constant.Constants.LOCALHOST_IP;
import static com.yoona.sharding.sphere.jdbc.common.constant.Constants.Number.*;
import static com.yoona.sharding.sphere.jdbc.common.constant.Constants.Symbol.DELIMITER_COMMA;
import static com.yoona.sharding.sphere.jdbc.common.constant.Constants.UNKNOWN;

/**
 * @author YoonaDa
 * @email lintiaoda@suntang.com
 * @description:
 * @date 2022-04-07 11:35
 */
public class IpUtil {

    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == ZERO || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == ZERO || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == ZERO || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (LOCALHOST_IP.equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                        ipAddress = inet.getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
            /**
             * 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
             */
            if (ipAddress != null && ipAddress.length() > FIFTEEN) {
                if (ipAddress.indexOf(DELIMITER_COMMA) > ZERO) {
                    ipAddress = ipAddress.substring(ZERO, ipAddress.indexOf(DELIMITER_COMMA));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }

}
