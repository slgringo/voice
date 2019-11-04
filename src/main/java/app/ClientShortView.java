package app;

/**
 * Краткое представление клиента (для списка)
 */
public class ClientShortView {
    private Integer id;
    private String name;
    private String address;
    private String managerName;
    private String managerPhone;
    private String viceManagerPhone;

    public ClientShortView(ClientModel client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
        if (client.getManagerModel() != null) {
            this.managerName = client.getManagerModel().getName();
            this.managerPhone = client.getManagerModel().getPhone();
            if (client.getManagerModel().getViceManagers() != null && !client.getManagerModel().getViceManagers().isEmpty()) {
                this.viceManagerPhone = client.getManagerModel().getViceManagers().get(0).getPhone();
            }
        }
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

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public String getViceManagerPhone() {
        return viceManagerPhone;
    }
}
