package service.implementation;

import dao.implementation.UserDaoImpl;
import entity.User;

public class UserServiceImpl {

    private UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public void add(User user) {
        userDao.create(user);
    }

}
