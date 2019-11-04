package app;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Репозиторий для сущностей Менеджер
 */
public interface ManagerRepository extends CrudRepository<ManagerModel, Integer> {
    ManagerModel findManagerByName(String name);
    List<ManagerModel> getAllByDeletedIsNullOrDeleted(Boolean deleted);
}
