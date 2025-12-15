package domain;


//厨师长当天菜肴统计
public class Caiyao {


    public int getMenunumber() {
        return menunumber;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    public String getMennuname() {
        return mennuname;
    }

    public void setMennuname(String mennuname) {
        this.mennuname = mennuname;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Caiyao{" +
                "menunumber=" + menunumber +
                ", mennuname='" + mennuname + '\'' +
                ", remarks='" + remarks + '\'' +
                ", number=" + number +
                '}';
    }

    private int menunumber ;
    private String mennuname;
    private String remarks;
    private int number;
}
