package Demo.Test.iocSimulation.service.impl;

import Demo.Test.iocSimulation.User;
import Demo.Test.iocSimulation.dao.UserDao;
import Demo.Test.iocSimulation.service.UserService;

/**
 * Created by fx on 2018/7/18.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void add(User user) {
        userDao.add(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl(UserDao userDao){

        super();
        this.userDao= userDao;
    }
}
