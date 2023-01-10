package app.controllers;

import app.exceptions.*;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Relation
@ControllerAdvice
@ResponseBody
public class ErrorController {
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageMaker categoryNotFound(final CategoryNotFoundException e)
    {
        return new MessageMaker(e.getMessage(), MessageMaker.ErrorCode.CATEGORY_NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageMaker productNotFound(final ProductNotFoundException e)
    {
        return new MessageMaker(e.getMessage(), MessageMaker.ErrorCode.PRODUCT_NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageMaker orderNotFound(final OrderNotFoundException e)
    {
        return new MessageMaker(e.getMessage(), MessageMaker.ErrorCode.ORDER_NOT_FOUND);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageMaker itemNotFound(final ItemNotFoundException e)
    {
        return  new MessageMaker(e.getMessage(), MessageMaker.ErrorCode.ITEM_NOT_FOUND);
    }

    /*

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionsAPI productNotFound(ProductNotFoundException text)
    {
        return ExceptionsAPI.builder()
                .message(text.getMessage())
                .status(ExceptionsAPI.ErrorCode.PRODUCT_NOT_FOUND)
                .build();
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionsAPI categoryNotFound(CategoryNotFoundException text)
    {
        return ExceptionsAPI.builder()
                .message(text.getMessage())
                .status(ExceptionsAPI.ErrorCode.CATEGORY_NOT_FOUND)
                .build();
    }

     */
}
