package domain;

import java.sql.Timestamp;

//与orderitem区别是，orderitem是数据库对应的字段，没有每个菜品的总金额，下单人，和电话
public class Orderitem2 {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getThistotalmoney() {
        return thistotalmoney;
    }

    public void setThistotalmoney(int thistotalmoney) {
        this.thistotalmoney = thistotalmoney;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Orderitem2{" +
                "id=" + id +
                ", ordernumber='" + ordernumber + '\'' +
                ", menunumber=" + menunumber +
                ", menuname='" + menuname + '\'' +
                ", unit='" + unit + '\'' +
                ", money='" + money + '\'' +
                ", number=" + number +
                ", date=" + date +
                ", remarks='" + remarks + '\'' +
                ", thistotalmoney=" + thistotalmoney +
                ", operator='" + operator + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    private int id;
    private String ordernumber;
    private int menunumber;
    private String menuname;
    private String unit;
    private String money;
    private int number;
    private Timestamp date;

    private String remarks;
    private int thistotalmoney;

    private String operator;

    private String phone;
}
