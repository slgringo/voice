package app;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с клиентами
 */
@Service
public class ClientService {
    private ClientRepository clientRepository;

    private ManagerRepository managerRepository;

    public ClientService(ClientRepository clientRepository, ManagerRepository managerRepository) {
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
    }

    public ClientModel createClient(ClientCreateRequest request) {
        ClientModel client = new ClientModel(request.name, request.address);
        client.setManagerModel(managerRepository.findManagerByName(request.managerName));
        clientRepository.save(client);
        return client;
    }

    public ClientModel updateClient(ClientCreateRequest request, Integer id) {
        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(request.name);
        client.setAddress(request.address);
        clientRepository.save(client);
        return client;

    }

    public List<ClientModel> getClientList() {
        return clientRepository.getAllByDeletedIsNullOrDeleted(false);
    }

    public ClientModel getClient(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteClient(Integer id) {
        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setDeleted(true);
        clientRepository.save(client);
    }
}
