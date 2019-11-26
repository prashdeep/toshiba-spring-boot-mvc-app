package com.toshiba.assetmgmtapp.util;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
    public static final String CORRELATION_ID = "correlation-id";

    private String correlationId= new String();

    public String getCorrelationId() { return correlationId;}

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

}