package app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель менеджера
 */
@Entity
public class ManagerModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private ManagerModel chief;

    @OneToMany(mappedBy = "chief")
    private List<ManagerModel> viceManagers;

    @OneToMany(mappedBy = "managerModel")
    private List<ClientModel> clients;

    public ManagerModel() {

    }

    public ManagerModel(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<ManagerModel> getViceManagers() {
        return viceManagers;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void addManager(ManagerModel manager) {
        if (viceManagers == null)
            viceManagers = new ArrayList<>();
        viceManagers.add(manager);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ManagerModel getChief() {
        return chief;
    }

    public void setChief(ManagerModel chief) {
        this.chief = chief;
    }
}
