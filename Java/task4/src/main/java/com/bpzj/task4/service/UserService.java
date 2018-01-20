package com.bpzj.task4.service;

import com.bpzj.task4.Util.CookieUtil;
import com.bpzj.task4.Util.JwtUtil;
import com.bpzj.task4.dao.UserMapper;
import com.bpzj.task4.domain.User;
import com.bpzj.task4.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.bpzj.task4.Util.SHA256Util.getSHA256Str;
import static com.bpzj.task4.Util.SHA256Util.getSalt;
import static com.bpzj.task4.service.Constant.COOKIE_NAME;
import static com.bpzj.task4.service.Constant.JWT_SECRET_KEY;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 userName 从数据库 取得 User
     * @param userName 登录者输入的用户名
     * @return 如果有User，返回User，没有的话，抛出错误
     * @throws Exception 不存在 对应 的 User
     */
    public User selectByUserName(String userName) throws Exception{
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty()) {
            throw new Exception("用户名不存在");
        } else {
            return userList.get(0);
        }
    }

    /**
     * 检查 注册 用户名 是否存在
     * @param userName 用户注册时 输入的用户名
     * @return 用户名存在返回 true ，不存在返回 false
     */
    public boolean isUserNameExist(String userName) {
        // userNameExist
        boolean userNameExist =false;
        try {
            // 如果原来就有用户名，不能注册，但是能登录
            selectByUserName(userName);
            userNameExist = true;
        } catch (Exception e) {
            userNameExist = false;
        }
        return userNameExist;
    }

    /**
     * 检查 登录时 密码 是否正确
     * @param user 登录用户传入的 数据，只有 用户名 和 密码
     * @return 检验值，true 或 false
     */
    public boolean checkLogin(User user, HttpServletResponse response, HttpSession session) {
        boolean loginFlag = false;
        User savedUser=null;
        try {
            // 从数据库中获取保存的用户
            savedUser = selectByUserName(user.getUserName());
            // 对比 加密后的 密码
            loginFlag = savedUser.getPassword().equals(getSHA256Str(user.getPassword() + savedUser.getUserKey()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 如果成功，设置 cookie, session
        if (loginFlag) {
            // 用JwtUtil生成token，秘钥为数据库中的 盐值，加密信息为 用户名
            String token = JwtUtil.getJwtToken(savedUser.getUserName(),JWT_SECRET_KEY);
            // 创建cookie，把 token 放到 cookie中，指定cookieName 为"key"
            CookieUtil.creatCookie(response, COOKIE_NAME, token, 60 * 60 * 3);

            // 设置session
            session.setAttribute("userName",savedUser.getUserName());
            // 这里时间单位 是 秒，设为10分钟
            session.setMaxInactiveInterval(60*10);
        }

        return loginFlag;
    }

    /**
     * 保存用户到数据库，注册时调用
     * @param user
     * @return
     */
    public int insertUser(User user) {
        String salt = getSalt();
        user.setUserKey(salt);
        // 先拼接，再加密，再保存
        user.setPassword(getSHA256Str(user.getPassword()+salt));
        // 创建用户时间和更新时间
        Date date =new Date();
        Long time = date.getTime();
        user.setCreateAt(time);
        user.setUpdateAt(time);
        return userMapper.insert(user);
    }
}
