package app;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с менеджерами
 */
@Service
public class ManagerService {
    private ManagerRepository managerRepository;
    private ClientRepository clientRepository;

    public ManagerService(ManagerRepository managerRepository, ClientRepository clientRepository) {
        this.managerRepository = managerRepository;
        this.clientRepository = clientRepository;
    }

    public ManagerModel createManager(ManagerCreateRequest request) {
        ManagerModel manager = new ManagerModel(request.name, request.phone);
        ManagerModel chief = managerRepository.findManagerByName(request.chief);
        if (chief != null)
            manager.setChief(chief);
        managerRepository.save(manager);
        return manager;
    }

    public ManagerModel updateManager(ManagerCreateRequest request, Integer id) {
        ManagerModel manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found"));
        manager.setName(request.name);
        manager.setPhone(request.phone);
        managerRepository.save(manager);
        return manager;
    }

    public List<ManagerModel> getManagerList() {
        return managerRepository.getAllByDeletedIsNullOrDeleted(false);
    }

    public List<ClientModel> getClientList(Integer id) {
        return clientRepository.getAllByDeletedIsNullOrDeletedAndManagerModelId(false, id);
    }

    public void deleteManager(Integer id) {
        ManagerModel manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found"));
        manager.setDeleted(true);
        managerRepository.save(manager);
    }
}
