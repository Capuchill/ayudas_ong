package com.ayudas.ong.util.exceptions.data_access;

import org.springframework.dao.DataAccessException;

public class ManagerAccessExcp extends DataAccessException {

    public ManagerAccessExcp(String msg) {
        super(msg);
    }

    public ManagerAccessExcp(String msg, Throwable string) {
        super(msg, string);
    }
    
}
