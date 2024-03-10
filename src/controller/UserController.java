package controller;

import model.User;
import model.UserDao;
import model.UserDaoImp;
import view.UserView;

import javax.swing.text.View;
import java.util.List;

public class UserController {
    private static final UserDao userDao = new UserDaoImp();
    private static  final UserView userView = new UserView();
    static List<User> users = userDao.getAllUser();

    public List<User> getAllUser(){
        return  userDao.getAllUser();

    }
    public  User searchAllUserById(Integer id){
        User user = userDao.searchUserById(id);
        return user;
    }

}
