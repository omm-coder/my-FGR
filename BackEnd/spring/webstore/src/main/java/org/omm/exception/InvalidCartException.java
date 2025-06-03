package org.omm.exception;

import lombok.Getter;

@Getter
public class InvalidCartException extends RuntimeException {

    private final String cartId;
    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

}
