import com.bpzj.task4.Util.DesUtil;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionTest {

    @Before
    public static byte[] initKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56); // 56 可填可不填

        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }


    @Test
    public void testDES() {
        try{
            // 使用DES加密 秘钥为字符串 "JAVA"
            DesUtil des = new DesUtil("JAVA");

            String username = "admin";
            Long logTime = System.currentTimeMillis();
            String time = "" +logTime;
            String last = username + "," + time;

            // 加密 拼接后的 姓名+时间 字符串
            String encryptedNameAndTime = des.encrypt(last);
            System.out.println("'姓名+时间'拼接后, DES加密值："+encryptedNameAndTime);

            // 解密
            String decryptedNameAndTime = des.decrypt(encryptedNameAndTime);
            System.out.println("上边加密值解密后："+decryptedNameAndTime);

            // 使用split分割字符串
            String[] decryptedStr = decryptedNameAndTime.split(",");
            String encryptedName = decryptedStr[0];
            String encryptedTime = decryptedStr[1];
            System.out.println(encryptedName);
            System.out.println(encryptedTime);

            // 直接 得到 time值 做对比
            Long logTime1 = Long.parseLong(time);
            System.out.println(logTime1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
