package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с менеджерами
 */
@RestController
public class ManagerController {
    private static final Logger LOG = LoggerFactory.getLogger(ManagerController.class);
    private static final String ERROR_CODE = "ERROR";

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    /**
     * Создать менеджера
     * @param request запрос
     * @return менеджер
     */
    @PostMapping("manager")
    public ManagerView createClient(@RequestBody ManagerCreateRequest request) {
        return new ManagerView(managerService.createManager(request));

    }

    /**
     * Обновить данные менеджера
     * @param id идентификтор менеджера
     * @param request запрос
     * @return менеджер
     */
    @PutMapping("manager/{id}")
    public ManagerView updateClient(@PathVariable("id") Integer id, @RequestBody ManagerCreateRequest request) {
        return new ManagerView(managerService.updateManager(request, id));
    }

    /**
     * Получить список менеджеров
     * @return список менеджеров
     */
    @GetMapping("manager")
    public List<ManagerView> getManagerList() {
        return managerService.getManagerList().stream().map(ManagerView::new).collect(Collectors.toList());
    }

    /**
     * Получить список клиентов для менеджера
     * @param id идентификтор менеджера
     * @return список клиентов
     */
    @GetMapping("manager/{id}/clients")
    public List<ClientShortView> getClientList(@PathVariable("id") Integer id) {
        return managerService.getClientList(id).stream().map(ClientShortView::new).collect(Collectors.toList());
    }

    /**
     * Удалить менеджера
     * @param id идентификтор менеджера
     */
    @DeleteMapping("manager/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        managerService.deleteManager(id);
    }

    /**
     * Обработчик исключений
     * @param ex исключение
     * @return ответ с кодом и текстом ошибки
     */
    @ExceptionHandler({Exception.class})
    public CommonResponse onError(Exception ex) {
        LOG.error(ex.getMessage());
        return new CommonResponse(ERROR_CODE, ex.getMessage());
    }
}
