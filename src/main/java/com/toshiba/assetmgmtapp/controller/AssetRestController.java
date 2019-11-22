package com.toshiba.assetmgmtapp.controller;

import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.service.AssetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/v1/assets/")
public class AssetRestController {

    private final AssetService assetService;

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
    public Asset saveAsset(@RequestBody Asset asset){
        System.out.println("Came inside the save asset method....");
        Asset savedAsset= this.assetService.saveAsset(asset);
        return savedAsset;
    }


}