package app;

import javax.persistence.*;

/**
 * Модель клиента
 */
@Entity
public class ClientModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name="manager_id", nullable=false)
    private ManagerModel managerModel;

    private Boolean deleted;

    public ClientModel() {

    }

    public ClientModel(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ManagerModel getManagerModel() {
        return managerModel;
    }

    public void setManagerModel(ManagerModel managerModel) {
        this.managerModel = managerModel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
