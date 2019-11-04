package app;

/**
 * Структура для возврата ошибок
 */
public class CommonResponse {
    private String code;
    private String message;

    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
