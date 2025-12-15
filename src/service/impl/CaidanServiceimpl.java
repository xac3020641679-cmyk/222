package service.impl;

import dao.CaidanDao;
import dao.Recipe;
import dao.impl.CaidanDaoimpl;
import dao.impl.Recipeimpl;
import domain.Caidan;
import domain.Caidanlist;
import service.CaidanService;

import java.util.List;

public class CaidanServiceimpl implements CaidanService {
    private CaidanDao dao = new CaidanDaoimpl();


    @Override
    public List<Caidan> findcaidan() {
        return dao.findcaidan();
    }

    @Override
    public List<Caidanlist> findcaidanlist(String ordernumber) {
        return dao.findcaidanlist(ordernumber);
    }

    @Override
    public Caidan findspecific(String ordernumber) {
        return dao.findspecific(ordernumber);
    }

    @Override
    public void CaidanUp(Caidan caidan) {
        dao.CaidanUp(caidan);
    }

    @Override
    public void upcaidanto(String ordernumber) {
        dao.upcaidanto(ordernumber);
    }
}
