package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class FindUserDao {


    //    声明一个对象共用，连接utils中的数据库连接池，写操作数据库的方法
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


//   没有查询到数据，返回null
    public domain.User finduser(domain.User registeruser) {

        try {
            String sql = "select * from user where username = ?";

//        调用query方法
            domain.User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<domain.User>(domain.User.class),
                    registeruser.getUsername());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
//            记录日志
            return null;
        }





    }

}
