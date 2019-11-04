package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с клиентами
 */
@RestController
public class ClientController {
    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);
    private static final String ERROR_CODE = "ERROR";

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Создать клиента
     * @param request запрос
     * @return клиент
     */
    @PostMapping("client")
    public ClientView createClient(@RequestBody ClientCreateRequest request) {
        return new ClientView(clientService.createClient(request));
    }

    /**
     * Обновить данные клиента
     * @param id идентификатор клиента
     * @param request запрос
     * @return клиент
     */
    @PutMapping("client/{id}")
    public ClientView updateClient(@PathVariable("id") Integer id,  @RequestBody ClientCreateRequest request) {
        return new ClientView(clientService.updateClient(request, id));
    }

    /**
     * Получить список клиентов
     * @return список клиентов
     */
    @GetMapping("client")
    public List<ClientShortView> getClientList() {
        return clientService.getClientList().stream().map(ClientShortView::new).collect(Collectors.toList());
    }

    /**
     * Получить клиента по идентификатору
     * @param id идентификатор клиента
     * @return клиент
     */
    @GetMapping("client/{id}")
    public ClientView getClent(@PathVariable("id") Integer id) {
        return new ClientView(clientService.getClient(id));
    }

    /**
     * Пометить клиента как удаленного
     * @param id идентификтор клиента
     */
    @DeleteMapping("client/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
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
