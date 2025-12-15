package dao;

import domain.Caidan;

import java.sql.Timestamp;
import java.util.List;

public interface Recipe {
    List<domain.Recipe> finAllRecipe();

    void addrecipe(List<String> recipes);

    void delselectedrecipe(int parseInt);

    domain.Recipe FindRecipe(String id);

    void updaterecipe(List<String> recipes);

    void delrecipe(String id);

    domain.Recipe findrecipe(int parseInt);

    void xcmenu(String ordernumber, Timestamp orderlistTime, domain.Recipe menu);

    void makecaidan(Caidan caidan);
}
