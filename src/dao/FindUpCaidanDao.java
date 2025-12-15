package dao;

import domain.Caidan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class FindUpCaidanDao {
    //    声明一个对象共用，连接utils中的数据库连接池，写操作数据库的方法
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    //   没有查询到数据，返回null
    public Caidan findupcaidan(Caidan upcaidan) {

        try {
            String sql = "select * from caidan where status = ?";

//        调用query方法
            Caidan caidan = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Caidan>(Caidan.class),
                    upcaidan.getStatus());


            return caidan;
        } catch (DataAccessException e) {
            e.printStackTrace();
//            记录日志
            return null;
        }





    }
}
