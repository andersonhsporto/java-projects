/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.exceptions;

/**
 *
 * @author ahigo
 */
public class FailedLoginException extends Exception {

    public FailedLoginException() {
    }

    public FailedLoginException(String message) {
        super(message);
    }

    public FailedLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedLoginException(Throwable cause) {
        super(cause);
    }

    public FailedLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
