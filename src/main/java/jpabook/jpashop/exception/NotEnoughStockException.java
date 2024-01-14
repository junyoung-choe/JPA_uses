package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) { // 메세지만 넘긴다
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) { // 메세지와 근원적 이유를 같이 넘겨준다
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
