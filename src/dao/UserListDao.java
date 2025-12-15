package dao;

import domain.Order;
import domain.User;

import java.util.List;

public interface UserListDao {

    void upuser(User user);

    List<User> findtjuser();

    List<Order> findorderstj(String username);

    User findszuser(String id);

    void upuser2(User user);

    User findmyphone(String username);

    Order findusername(String ordernumber);

    void adduser(User user);
}
