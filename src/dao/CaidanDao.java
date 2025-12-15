package dao;

import domain.Caidan;
import domain.Caidanlist;

import java.util.List;

public interface CaidanDao {
    List<Caidan> findcaidan();

    List<Caidanlist> findcaidanlist(String ordernumber);

    Caidan findspecific(String ordernumber);

    void CaidanUp(Caidan caidan);

    void upcaidanto(String ordernumber);

    void Deletecaidan(String ordernumber);

    void delcaidanitem(String id, String ordernumber);

    Caidanlist findcaidanitem(String id);

    void updatecaidanlist(List<String> recipes);

    Caidan findcaidan1();
}
