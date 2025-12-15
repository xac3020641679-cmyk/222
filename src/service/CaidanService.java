package service;

import domain.Caidan;
import domain.Caidanlist;

import java.util.List;

public interface CaidanService {
    List<Caidan> findcaidan();

    List<Caidanlist> findcaidanlist(String ordernumber);

    Caidan findspecific(String ordernumber);

    void CaidanUp(Caidan caidan);

    void upcaidanto(String ordernumber);
}
