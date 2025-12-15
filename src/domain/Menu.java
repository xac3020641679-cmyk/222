package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Menu implements Serializable {
    private Long id;
    private String name;
    private LocalDate dateCreated;
    private List<MenuItem> items;

    public Menu() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDate dateCreated) { this.dateCreated = dateCreated; }
    public List<MenuItem> getItems() { return items; }
    public void setItems(List<MenuItem> items) { this.items = items; }
}
