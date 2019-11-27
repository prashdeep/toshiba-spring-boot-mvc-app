package com.toshiba.assetmgmtapp.events.source;

import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.util.UserContext;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    private final Source source;


    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishOrgChange(Asset asset){
        System.out.println("publishing the message ... "+ asset);
        source.output().send(MessageBuilder.withPayload(asset).build());
    }
}
