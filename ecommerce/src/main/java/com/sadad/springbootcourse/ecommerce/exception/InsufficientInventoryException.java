package com.sadad.springbootcourse.ecommerce.exception;

public class InsufficientInventoryException extends RuntimeException {

    public InsufficientInventoryException(String message) {
        super(message);
    }
}
