package app;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Представление менеджера
 */
public class ManagerView {
    private Integer id;
    private String name;
    private String phone;
    private List<ManagerView> viceManagers;

    public ManagerView(ManagerModel manager) {
        this.id = manager.getId();
        this.name = manager.getName();
        this.phone = manager.getPhone();
        if (manager.getViceManagers() != null) {
            this.viceManagers = manager.getViceManagers().stream().map(ManagerView::new).collect(Collectors.toList());
        }
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

    public List<ManagerView> getViceManagers() {
        return viceManagers;
    }
}
