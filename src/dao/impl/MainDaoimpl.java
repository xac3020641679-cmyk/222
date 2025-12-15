package dao.impl;

import dao.MainDao;
import domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Timestamp;
import java.util.List;

public class MainDaoimpl implements MainDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Caidan findstatus0() {
        String sql = "select * from caidan where status = 1";


        return template.queryForObject(sql,new BeanPropertyRowMapper<Caidan>(Caidan.class));
    }

    @Override
    public List<Caidanlist> findupcaidan(String ordernumber) {
        String sql = "select * from caidanlist where ordernumber = ?";
        List<Caidanlist> caidanlist = template.query(sql,new BeanPropertyRowMapper<Caidanlist>(Caidanlist.class),ordernumber);
        return caidanlist;
    }

    @Override
    public Caidanlist addgouwuche(String id) {
        String sql = "select * from caidanlist where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Caidanlist>(Caidanlist.class),id);
    }

    @Override
    public void addtotalorder(String username, String name, int totalmoney, Timestamp orderlistTime, String ordernumber) {
        String sql = "insert into orderfrom values(null , ? ,?,?,?,? )";
        template.update(sql,username,name,totalmoney,orderlistTime,ordernumber);
    }

    @Override
    public void addorderitem(Orderitem orderitem) {
        String sql = "insert into orderitem values(null , ? ,?,?,?,?,?,? ,?)";
        template.update(sql,orderitem.getOrdernumber(),orderitem.getMenunumber(),orderitem.getMenuname(),orderitem.getUnit(),orderitem.getMoney(),orderitem.getNumber(),orderitem.getDate(),orderitem.getRemarks());
    }

    @Override
    public List<Order> findmyorder(String username) {
        String sql = "select * from orderfrom where username = ?";
        List<Order> orders = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),username);
        return orders;
    }

    @Override
    public void delmyorder(String ordernumber) {
        String sql = "delete from orderfrom where ordernumber = ?";

        template.update(sql,ordernumber);
    }

    @Override
    public List<Orderitem> findorderitems(String ordernumber) {
        String sql = "select * from orderitem where ordernumber = ?";
        List<Orderitem> orderitems = template.query(sql,new BeanPropertyRowMapper<Orderitem>(Orderitem.class),ordernumber);
        return orderitems;
    }
}
