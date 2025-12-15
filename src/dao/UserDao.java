package dao;


import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

//操作数据库user类
public class UserDao {

//    声明一个对象共用，连接utils中的数据库连接池，写操作数据库的方法
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

//    登录方法，loginUSer只有用户名和密码，user包含全部数据
//   没有查询到数据，返回null
    public domain.User login(domain.User loginUser) {

        try {
            String sql = "select * from user where username = ? and password = ?";

//        调用query方法
            domain.User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<domain.User>(domain.User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
//            记录日志
            return null;
        }





    }


}

