package Demo.Test.iocSimulation;

import Demo.Test.iocSimulation.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fx on 2018/7/18.
 */
public class IocApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("User.xml");
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        User u = new User();
        u.setPassword("123456");
        u.setUsername("admin");
        userService.add(u);
    }
}
