package login;

import javax.crypto.*;
import javax.crypto.spec.*;
/**AES加密解密类**/
public class aes {
	//加密方法
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            if (sKey == null) {//判断密钥是否为空
                return null;
            }
            if (sKey.length() != 16) { //判断密钥是否为16位字符型，也就是128位二进制数
                return null;
            }
            //加密迭代过程
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = hex2byte(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;//得到密文
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
    //解密方法
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {   //判断Key是否正确
            return null;
        }   
        if (sKey.length() != 16) {//判断Key是否为16位
            return null;
        }
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return byte2hex(encrypted).toLowerCase();//得到明文
    }
    //十六进制转二进制
    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }
    //二进制转十六进制
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}

