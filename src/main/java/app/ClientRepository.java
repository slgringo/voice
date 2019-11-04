package app;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Репозиторий для сущности Клиент
 */
public interface ClientRepository extends CrudRepository<ClientModel, Integer> {
    List<ClientModel> getAllByDeletedIsNullOrDeleted(Boolean deleted);
    List<ClientModel> getAllByDeletedIsNullOrDeletedAndManagerModelId(Boolean deleted, Integer id);
}
