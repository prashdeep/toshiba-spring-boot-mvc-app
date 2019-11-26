package com.toshiba.assetmgmtapp.config;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringBeanConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean(name = "mycustombean")
    //@ConditionalOnProperty(prefix = "bean", value = "disable", havingValue = "false", matchIfMissing = true)
    public Asset assetBean(){
        return new Asset();
    }

}