package com.toshiba.assetmgmtapp.controller;

import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.service.AssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public String fetchAllAssets(Model model){
        List<Asset> assetList = this.assetService.listAll();
        model.addAttribute("assets", assetList);
        return "assets";
    }

    @GetMapping("/{id}")
    public String fetchAssetById(@PathVariable("id") long assetId, Model model){
        Asset asset = this.assetService.findByAssetId(assetId);
        model.addAttribute("asset", asset);
        return "asset-details";
    }

    @PostMapping
    public String saveAsset(Asset asset){
        this.assetService.saveAsset(asset);
        return "redirect:/assets";
    }

    @PutMapping("/{id}")
    public String updateAsset(@PathVariable long id, Asset asset, Model model){
        this.assetService.updateAsset(id, asset);
        return "redirect:/assets";
    }
}