package Demo.Test.iocSimulation.dao.impl;

import Demo.Test.iocSimulation.User;
import Demo.Test.iocSimulation.dao.UserDao;

/**
 * Created by fx on 2018/7/18.
 */
public class UserDaoImpl implements UserDao{
    public void add(User user) {
        System.out.println(user.getUsername()+" 已经存储！");
    }
}
