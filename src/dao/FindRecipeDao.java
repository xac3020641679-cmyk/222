package dao;

import domain.Recipe;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class FindRecipeDao {
    //    声明一个对象共用，连接utils中的数据库连接池，写操作数据库的方法
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public Recipe findaddrecipe(Recipe isfindaddmenu) {

        try {
            String sql = "select * from recipe where menunumber = ?";

//        调用query方法
            Recipe recipe = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Recipe>(Recipe.class),
                    isfindaddmenu.getMenunumber());


            return recipe;
        } catch (DataAccessException e) {
            e.printStackTrace();
//            记录日志
            return null;
        }


    }
}
