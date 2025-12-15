package domain;

import java.sql.Timestamp;

public class Caidan {
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Caidan{" +
                "id=" + id +
                ", ordernumber='" + ordernumber + '\'' +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", status=" + status +
                '}';
    }

    private int id ;
    private String ordernumber;
    private java.sql.Timestamp date;
    private String operator;
    private int status;
}
