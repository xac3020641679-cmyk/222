package dao;

import domain.*;
import domain.Recipe;

import java.sql.Timestamp;
import java.util.List;

public interface MainDao {

    Caidan findstatus0();

    List<Caidanlist> findupcaidan(String ordernumber);

    Caidanlist addgouwuche(String id);

    void addtotalorder(String username, String name, int totalmoney, Timestamp orderlistTime, String ordernumber);

    void addorderitem(Orderitem orderitem);

    List<Order> findmyorder(String username);

    void delmyorder(String ordernumber);

    List<Orderitem> findorderitems(String ordernumber);

}
