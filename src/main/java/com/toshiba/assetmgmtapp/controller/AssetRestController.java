package com.toshiba.assetmgmtapp.controller;

import com.toshiba.assetmgmtapp.config.ApplicationConfiguration;
import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/v1/assets/")
@RefreshScope
public class AssetRestController {

    private final AssetService assetService;

    @Value("${custom.message}")
    private String message;

    @Autowired
    private ApplicationConfiguration configurationProperties;

    public AssetRestController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
    public List<Asset> listAll(){
        return this.assetService.listAll();
    }

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Asset findAssetById(@PathVariable("id") long assetId){
        return this.assetService.findByAssetId(assetId);
    }

    @PostMapping(consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Asset saveAsset(  @RequestBody Asset asset){
        System.out.println("Came inside the save asset method.... "+ asset);
        Asset savedAsset= this.assetService.saveAsset(asset);
        return savedAsset;
    }

    public ApplicationConfiguration getConfigurationProperties() {
        return configurationProperties;
    }

    public void setConfigurationProperties(ApplicationConfiguration configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @GetMapping("/profile")
    public String profile(){
        return "{\"message\":\""+this.configurationProperties.getMessage()+"\"}";
    }

    @GetMapping("/test")
    public String test(){
        return "{message:\" \""+this.message+"\"}";
    }


    @GetMapping("/organization/{id}")
    public String fetchOrganizationById(@PathVariable("id") long id){
        return this.assetService.fetchOrgById(id);

    }

}