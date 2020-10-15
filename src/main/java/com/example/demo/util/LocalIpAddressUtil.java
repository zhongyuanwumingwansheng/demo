package com.example.demo.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class LocalIpAddressUtil {
    public static Set<InetAddress> resolveLocalAddresses(){
        Set<InetAddress> addresses = new HashSet<>();
        Enumeration<NetworkInterface> networkInterfaceEnumeration = null;

        try {
            networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        } catch (Exception ex) {

        }

        while(networkInterfaceEnumeration != null
                && networkInterfaceEnumeration.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
            while (inetAddressEnumeration.hasMoreElements()){
                InetAddress inetAddress = inetAddressEnumeration.nextElement();
                if(!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() &&
                        !inetAddress.isMulticastAddress()){
                    addresses.add(inetAddress) ;
                }
            }
        }

        return addresses;
    }

    public static String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
            throw new RuntimeException("");
        }
    }

    public static String getHostAddress(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            throw new RuntimeException("");
        }
    }

    public static Set<String> resolveLocalIps(){
        Set<InetAddress> addresses = resolveLocalAddresses();
        Set<String> ret = new HashSet<>();
        for(InetAddress inetAddress: addresses){
            ret.add(inetAddress.getHostAddress());
        }
        return ret;
    }

    public static InetAddress resolveLocalAddress(){
        Set<InetAddress> addresses = resolveLocalAddresses();
        if(addresses != null && !addresses.isEmpty()){
            return addresses.iterator().next();
        }
        return null;
    }
}
