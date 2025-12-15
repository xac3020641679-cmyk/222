package dao.impl;

import dao.CaidanDao;
import domain.Caidan;
import domain.Caidanlist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CaidanDaoimpl  implements CaidanDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Caidan> findcaidan() {
        String sql = "select * from caidan ";
        List<Caidan> caidanlist = template.query(sql,new BeanPropertyRowMapper<Caidan>(Caidan.class));
        return caidanlist;
    }

    @Override
    public List<Caidanlist> findcaidanlist(String ordernumber) {
        String sql = "select * from caidanlist where ordernumber = ?";
        List<Caidanlist> caidanlist = template.query(sql,new BeanPropertyRowMapper<Caidanlist>(Caidanlist.class),ordernumber);
        return caidanlist;
    }

    @Override
    public Caidan findspecific(String ordernumber) {
        String sql = "select * from caidan where ordernumber = ?";


        return template.queryForObject(sql,new BeanPropertyRowMapper<Caidan>(Caidan.class),ordernumber);
    }

    @Override
    public void CaidanUp(Caidan caidan) {
        String sql = "update caidan set status = ? where ordernumber = ?";

        template.update(sql,caidan.getStatus(),caidan.getOrdernumber());
    }

    @Override
    public void upcaidanto(String ordernumber) {
        String sql = "update caidan set status = 0 where ordernumber = ?";

        template.update(sql,ordernumber);
    }

    @Override
    public void Deletecaidan(String ordernumber) {
        String sql = "delete from caidan where ordernumber = ?";

        template.update(sql,ordernumber);
    }

    @Override
    public void delcaidanitem(String id, String ordernumber) {
        String sql = "delete from caidanlist where id = ?";

        template.update(sql,id);
    }

    @Override
    public Caidanlist findcaidanitem(String id) {
        String sql = "select * from caidanlist where id = ?";


        return template.queryForObject(sql,new BeanPropertyRowMapper<Caidanlist>(Caidanlist.class),id);
    }

    @Override
    public void updatecaidanlist(List<String> recipes) {
        String sql = "update caidanlist set  kind = ? ,menuname = ? , menupicture = ? , unit = ? , money = ? ,remarks = ? where id = ?";

        template.update(sql,recipes.get(1),recipes.get(2),recipes.get(3),recipes.get(4),recipes.get(5),recipes.get(6),recipes.get(0));
    }

    @Override
    public Caidan findcaidan1() {
        String sql = "select * from caidan where status = 1";


        return template.queryForObject(sql,new BeanPropertyRowMapper<Caidan>(Caidan.class));
    }
}
