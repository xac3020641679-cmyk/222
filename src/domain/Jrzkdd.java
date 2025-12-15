package domain;

import java.sql.Timestamp;

//今日总括订单实体
public class Jrzkdd {

    public int getMenunumber() {
        return menunumber;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getThistotalmoney() {
        return thistotalmoney;
    }

    public void setThistotalmoney(int thistotalmoney) {
        this.thistotalmoney = thistotalmoney;
    }

    @Override
    public String toString() {
        return "Jrzkdd{" +
                "menunumber=" + menunumber +
                ", menuname='" + menuname + '\'' +
                ", money='" + money + '\'' +
                ", number=" + number +
                ", thistotalmoney=" + thistotalmoney +
                '}';
    }

    private int menunumber;
    private String menuname;
    private String money;
    private int number;
    private int thistotalmoney;
}
