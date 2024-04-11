package com.ayudas.ong.util.exceptions.data_access;

public class ErrorEnumsFind extends IllegalArgumentException {
    
    public ErrorEnumsFind(String msg) {
        super(msg);
    }

    public ErrorEnumsFind(String msg, Throwable causa) {
        super(msg, causa);
    }

}
