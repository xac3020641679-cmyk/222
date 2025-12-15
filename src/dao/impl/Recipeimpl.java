package dao.impl;

import dao.Recipe;
import domain.Caidan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Timestamp;
import java.util.List;

public class Recipeimpl implements Recipe {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<domain.Recipe> finAllRecipe() {

//        用jdbc操作数据库
//        定义sql
        String sql = "select * from recipe";
        List<domain.Recipe> recipes = template.query(sql,new BeanPropertyRowMapper<domain.Recipe>(domain.Recipe.class));

        return recipes;
    }

    @Override
    public void addrecipe(List<String> recipes) {
        String sql = "insert into recipe values(null,?,?,?,?,?,?)";

        template.update(sql,recipes.get(2),recipes.get(1),recipes.get(0),recipes.get(3),recipes.get(4),recipes.get(5));
    }

    @Override
    public void delselectedrecipe(int id) {
        String sql = "delete from recipe where id = ?";

        template.update(sql,id);
    }

    @Override
    public domain.Recipe FindRecipe(String id) {
        String sql = "select * from recipe where id = ?";


        return template.queryForObject(sql,new BeanPropertyRowMapper<domain.Recipe>(domain.Recipe.class),id);

    }

    @Override
    public void updaterecipe(List<String> recipes) {
        String sql = "update recipe set  kind = ? ,menuname = ? , menupicture = ? , unit = ? , money = ? ,remarks = ? where id = ?";

        template.update(sql,recipes.get(1),recipes.get(2),recipes.get(3),recipes.get(4),recipes.get(5),recipes.get(6),recipes.get(0));
    }

    @Override
    public void delrecipe(String id) {
        String sql = "delete from recipe where id = ?";

        template.update(sql,Integer.parseInt(id));
    }

    @Override
    public domain.Recipe findrecipe(int id) {
        String sql = "select * from recipe where id = ?";


        return template.queryForObject(sql,new BeanPropertyRowMapper<domain.Recipe>(domain.Recipe.class),id);
    }

    @Override
    public void xcmenu(String ordernumber, Timestamp orderlistTime, domain.Recipe menu) {
        String sql = "insert into caidanlist values(?,?,?,?,?,?,?,?,null , ? )";

        template.update(sql,ordernumber,menu.getId(),menu.getKind(),menu.getMenuname(),menu.getMenupicture(),menu.getUnit(),menu.getMoney(),orderlistTime,menu.getRemarks());
    }

    @Override
    public void makecaidan(Caidan caidan) {
        String sql = "insert into caidan values(null ,?,?,?,?)";

        template.update(sql,caidan.getOrdernumber(),caidan.getDate(),caidan.getOperator(),caidan.getStatus());
    }
}
