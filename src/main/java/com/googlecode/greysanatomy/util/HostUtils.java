package com.googlecode.greysanatomy.util;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

/**
 * �����жϹ�����
 * Created by vlinux on 14/10/23.
 */
public class HostUtils {

    /**
     * �жϵ�ǰ�������Ƿ񱾵�����
     *
     * @param targetIp
     * @return
     */
    public static boolean isLocalHostIp(String targetIp) {

        for (String ip : getAllLocalHostIP()) {
            if (ip.equals(targetIp)) {
                return true;
            }
        }

        return false;
    }

    /**
     * ��ȡ��ǰ������
     *
     * @return
     */
    public static String getLocalHostName() {
        String hostName;
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostName = address.getHostName();
        } catch (Exception ex) {
            hostName = "";
        }
        return hostName;
    }

    /**
     * ��ȡ����������������IP
     *
     * @return
     */
    public static Set<String> getAllLocalHostIP() {
        final Set<String> ret = new HashSet<String>();
        ret.add("127.0.0.1");
        try {
            final String hostName = getLocalHostName();
            final InetAddress[] address = InetAddress.getAllByName(hostName);
            for (int i = 0; i < address.length; i++) {
                final String ip = address[i].getHostAddress();
                if (ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$")) {
                    ret.add(address[i].getHostAddress());
                }
            }

        } catch (Exception ex) {
//            ret = null;
        }
        return ret;
    }

}
