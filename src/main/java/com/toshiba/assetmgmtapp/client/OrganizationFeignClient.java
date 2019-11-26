package com.toshiba.assetmgmtapp.client;

import com.toshiba.assetmgmtapp.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "organizationservice" )
public interface OrganizationFeignClient {
  @RequestMapping(
            value = "/v1/organization/{id}",
            method = RequestMethod.GET,
            consumes = "application/json"
  )

    public Organization getOrganizationById(@PathVariable("id") long organizationId);
}
