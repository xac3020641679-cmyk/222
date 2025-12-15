package service.impl;

import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.User;
import service.UserService;

public class UserServiceimpl implements UserService {
    private UserListDao dao = new UserListDaoimpl();

    @Override
    public void upuser(User user) {
         dao.upuser(user);
    }
}
