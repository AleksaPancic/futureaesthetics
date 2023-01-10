package app.exceptions;

import lombok.Value;

@Value
public class MessageMaker {
     String message;
     ErrorCode status;
    public enum ErrorCode {
        PRODUCT_NOT_FOUND, CATEGORY_NOT_FOUND, ORDER_NOT_FOUND,
        ITEM_NOT_FOUND
    }
}
