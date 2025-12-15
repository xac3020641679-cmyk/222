package service.impl;

import dao.Recipe;
import dao.UserListDao;
import dao.impl.Recipeimpl;
import dao.impl.UserListDaoimpl;
import domain.Caidan;
import service.RecipeService;

import java.sql.Timestamp;

public class RecipeServiceimpl implements RecipeService {
    private Recipe dao = new Recipeimpl();


    @Override
    public void delselectedrecipe(String[] recipeids) {
        if (recipeids !=null && recipeids.length > 0){
            for (String id : recipeids){
                dao.delselectedrecipe(Integer.parseInt(id));
            }
        }
    }

    @Override
    public domain.Recipe FindRecipe(String id) {
        return dao.FindRecipe(id);
    }

    @Override
    public domain.Recipe findrecipe(String id) {
        return dao.findrecipe(Integer.parseInt(id));
    }

    @Override
    public void xcmenu(String ordernumber, Timestamp orderlistTime, domain.Recipe menu) {
        dao.xcmenu(ordernumber,orderlistTime, menu);
    }

    @Override
    public void makecaidan(Caidan caidan) {
        dao.makecaidan(caidan);
    }
}
