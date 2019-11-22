package com.toshiba.assetmgmtapp.config;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfiguration {
    @Bean(name = "mycustombean")
    //@ConditionalOnProperty(prefix = "bean", value = "disable", havingValue = "false", matchIfMissing = true)
    public Asset assetBean(){
        return new Asset();
    }

}