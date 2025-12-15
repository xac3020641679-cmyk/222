package domain;

//个人订单月度统计实体

import java.sql.Timestamp;

public class Grydtj {

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getThistotalmoney() {
        return thistotalmoney;
    }

    public void setThistotalmoney(int thistotalmoney) {
        this.thistotalmoney = thistotalmoney;
    }

    @Override
    public String toString() {
        return "Grydtj{" +
                "menuname='" + menuname + '\'' +
                ", unit='" + unit + '\'' +
                ", money='" + money + '\'' +
                ", number=" + number +
                ", date=" + date +
                ", thistotalmoney=" + thistotalmoney +
                '}';
    }

    private String menuname;
    private String unit;
    private String money;
    private int number;
    private Timestamp date;
    private int thistotalmoney;

}
