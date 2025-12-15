package dao.impl;

import dao.UserListDao;
import domain.Order;
import domain.Orderitem;
import domain.Recipe;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserListDaoimpl implements UserListDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void upuser(User user) {
        String sql = "update user set password = ?  , name = ? , phone = ? , status = ? where id = ?";

        template.update(sql,user.getPassword(),user.getName(),user.getPhone(),user.getStatus(),user.getId());
    }

    @Override
    public List<User> findtjuser() {
        String sql = "select * from user";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public List<Order> findorderstj(String username) {
        String sql = "select * from orderfrom where username = ?";
        List<Order> orders = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),username);
        return orders;
    }

    @Override
    public User findszuser(String id) {
        String sql = "select * from user where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),Integer.parseInt(id));
    }

    @Override
    public void upuser2(User user) {
        String sql = "update user set password = ?  , name = ? , phone = ? , status = ? ,wisdom = ? where id = ?";

        template.update(sql,user.getPassword(),user.getName(),user.getPhone(),user.getStatus(),user.getWisdom(),user.getId());

    }

    @Override
    public User findmyphone(String username) {
        String sql = "select * from user where username = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
    }

    @Override
    public Order findusername(String ordernumber) {
        String sql = "select * from orderfrom where ordernumber = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<Order>(Order.class),ordernumber);
    }

    @Override
    public void adduser(User user) {
        String sql = "insert into user values(null , ? ,?,?,?,?,? )";

        template.update(sql,user.getUsername(),user.getPassword(),user.getWisdom(),user.getName(),user.getPhone(),user.getStatus());
    }
}
