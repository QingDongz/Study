package com.bpzj.task4.service;

import com.bpzj.task4.dao.UserMapper;
import com.bpzj.task4.domain.User;
import com.bpzj.task4.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.bpzj.task4.Util.SHA256Util.getSHA256Str;
import static com.bpzj.task4.Util.SHA256Util.getSalt;

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
    private User selectByUserName(String userName) throws Exception{
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
    public boolean checkLogin(User user) {
        boolean loginFlag = false;
        try {
            // 从数据库中获取保存的用户
            User savedUser = selectByUserName(user.getUserName());
            // 对比 加密后的 密码
            loginFlag = savedUser.getPassword().equals(getSHA256Str(user.getPassword() + savedUser.getUserKey()));

        } catch (Exception e) {
            e.printStackTrace();
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
        userMapper.insert(user);
        return userMapper.insert(user);
    }
}
