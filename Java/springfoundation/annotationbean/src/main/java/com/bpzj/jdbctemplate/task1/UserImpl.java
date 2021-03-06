package com.bpzj.jdbctemplate.task1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository("user")   通过value="user" 指定 bean, 如果不指定value
// 在测试类 TestAnnotation中，需要更改getBean的name，否则报错。
// 或者在引用这个类的地方，也就是UserService类中，使用 @Qualifier 注解指定
@Component()
public class UserImpl implements User {

    private House house;

    @Autowired
    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public void save() {
        System.out.println("UserImpl 的 save 方法");
        house.express();
    }

}
