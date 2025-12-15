package service;

import domain.Caidan;
import domain.Recipe;

import java.sql.Timestamp;

public interface RecipeService {

    void delselectedrecipe(String[] recipeids);

    Recipe FindRecipe(String id);

    Recipe findrecipe(String id);

    void xcmenu(String ordernumber, Timestamp orderlistTime, Recipe menu);

    void makecaidan(Caidan caidan);
}
