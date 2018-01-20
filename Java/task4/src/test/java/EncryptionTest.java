import com.bpzj.task4.Util.DesUtil;
import org.junit.Test;

import static com.bpzj.task4.Util.JwtUtil.getJwtToken;
import static com.bpzj.task4.Util.JwtUtil.jwtDecrypt;

public class EncryptionTest {

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

    @Test
    public void testJwt() {
        String token = getJwtToken("writeKey", "hello zhwy");
        System.out.println(token);

        // 用正确秘钥解密，得到正确信息
        System.out.println(jwtDecrypt("writeKey", token));
        // 用错误秘钥解密，报错
        System.out.println(jwtDecrypt("wrongKey", token));

    }

}
