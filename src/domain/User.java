package domain;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String name;
    private String loginName;
    private String password;
    private String phone;
    private String department;
    private String seatInfo;
    private String role; // e.g. MANAGER, KITCHEN, DELIVERY, FINANCE, EMPLOYEE

    public User() {}

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLoginName() { return loginName; }
    public void setLoginName(String loginName) { this.loginName = loginName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getSeatInfo() { return seatInfo; }
    public void setSeatInfo(String seatInfo) { this.seatInfo = seatInfo; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
