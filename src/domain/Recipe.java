package domain;

import java.io.Serializable;

public class Recipe implements Serializable {
    private Long id;
    private String name;
    private String category; // 主食/点心/菜肴 等
    private String imageUrl;
    private String unit; // 份/两/个/杯
    private double unitPrice;
    private String cookNotes; // 可选，不在菜单显示

    public Recipe() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    public String getCookNotes() { return cookNotes; }
    public void setCookNotes(String cookNotes) { this.cookNotes = cookNotes; }
}
