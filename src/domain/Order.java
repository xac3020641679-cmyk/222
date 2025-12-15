package domain;

import java.sql.Timestamp;

public class Order {

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordernumber='" + ordernumber + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", totalmoney=" + totalmoney +
                ", date=" + date +
                '}';
    }

    private int id;
    private String ordernumber;
    private String username;
    private String name;
    private int totalmoney;
    private Timestamp date;
}
