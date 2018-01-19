package com.bpzj.task4.Util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class SHA256Util {


    public static String getSHA256Str(String message){
        MessageDigest messageDigest = null;
        String SHAStr = "";

        try {
            // ============指定加密 算法============
            messageDigest = MessageDigest.getInstance("SHA-256");
            // ============更新加密信息到
            messageDigest.update(message.getBytes("UTF-8"));
            // ============得到bytes转换后的字符串
            byte[] digest = messageDigest.digest();
            SHAStr = bytesToHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return SHAStr;
    }

    /**
     * @return 返回 一个 盐值
     */
    public static String getSalt(){
        byte[] bytes = new byte[10];
        Random ranGen = new SecureRandom();
        ranGen.nextBytes(bytes);

        // ( 用jdk math包的 BigInteger 把 bytes转换为16进制 )
        // String str = new BigInteger(1,bytes).toString(16);

        // 使用自己写的函数把 bytes转换为16进制，方法在下面
        return bytesToHexString(bytes);

    }

    /**
     * bytes 转为 16 进制字符串
     * @param bytes
     * @return
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
        // foreach 的用法
        for (byte aByte:bytes)  {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }


    /**
     * 测试 加密方法
     * @param args
     */
    public static void main(String[] args) {
        String salt = getSalt();
        System.out.println(salt);
        String message = "this is a message";
        String encryptedMessage = getSHA256Str(message);
        System.out.println(encryptedMessage);
    }
}
