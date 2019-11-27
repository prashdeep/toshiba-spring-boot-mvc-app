package com.toshiba.assetmgmtapp.config;

import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.util.UserContextInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class SpringBeanConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors==null){
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }
        else{
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }

        return template;
    }
    @Bean(name = "mycustombean")
    //@ConditionalOnProperty(prefix = "bean", value = "disable", havingValue = "false", matchIfMissing = true)
    public Asset assetBean(){
        return new Asset();
    }

}