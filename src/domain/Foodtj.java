package domain;

import java.util.List;

public class Foodtj {


    public String getMennuname() {
        return mennuname;
    }

    public void setMennuname(String mennuname) {
        this.mennuname = mennuname;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getCishu() {
        return cishu;
    }

    public void setCishu(int cishu) {
        this.cishu = cishu;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Foodtj{" +
                "mennuname='" + mennuname + '\'' +
                ", money='" + money + '\'' +
                ", cishu=" + cishu +
                ", list=" + list +
                '}';
    }

    private String mennuname;

    private String money;
    private int cishu;
    private List list;


}
