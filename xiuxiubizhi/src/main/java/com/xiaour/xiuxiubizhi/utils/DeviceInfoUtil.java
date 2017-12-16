package com.xiaour.xiuxiubizhi.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DeviceInfoUtil {
	
	public static String getDivice(String info){
		String temp=null;
		if(info.contains("iPhone")){
			temp="iPhone";
		}
		if(info.contains("Android")){
			temp="Android";
		}
		if(info.contains("Windows")){
			temp="Windows";
		}
		if(info.contains("iPad")){
			temp="iPad";
		}
		if(info.contains("Ubuntu")){
			temp="Ubuntu";
		}
		if(info.contains("CentOS")){
			temp="CentOS";
		}
		if(info.contains("Mac")){
			temp="MacOS";
		}
		return temp;
	}
	
	public static String getInfo(String info){
		String temp=null;

		if(info.contains("MicroMessenger")){
			temp="微信";
		} else if(info.contains("Safari")&&!info.contains("Chrome")&&!info.contains("QQ")){
			temp="Safari";
		}
		 else if(info.contains("QQ")||info.contains("MQQBrowser")){
			 temp="QQ";
		}
		 else if(info.contains("LBBROWSER")){
			 temp="猎豹浏览器";
		}
		 else if(info.contains("Chrome")||info.contains("Safari")){
			 temp="Chrome";
		}
		 else if(info.contains("DingTalk")){
			 temp="钉钉";
		 }
		 else if(info.contains("Trident")){
			 temp="IE或Trident内核";
		}
		 else if(info.contains("firefox")||info.contains("FireFox")){
			 temp="FireFox";
		}else{
			temp="未知";
		}
		return temp;
	}
	
	public static String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for"); 
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        e.printStackTrace();  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>=1){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            return ipAddress;   
    }  

}
