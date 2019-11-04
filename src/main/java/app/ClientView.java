package app;

/**
 * Полное представление клиента
 */
public class ClientView {
    private Integer id;
    private String name;
    private String address;
    private ManagerView manager;

    public ClientView(ClientModel client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
        if (client.getManagerModel() != null) {
            this.manager = new ManagerView(client.getManagerModel());
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

    public ManagerView getManager() {
        return manager;
    }
}
