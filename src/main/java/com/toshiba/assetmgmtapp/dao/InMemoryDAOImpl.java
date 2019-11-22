package com.toshiba.assetmgmtapp.dao;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("inmemory")
//@Profile("dev")
public class InMemoryDAOImpl implements AssetDAO {

    private static List<Asset> assets = new ArrayList<>();

    static {
        assets.add(Asset.builder().id(34).name("lenovo").price(55_000).build());
        assets.add(Asset.builder().id(35).name("Asus").price(56_000).build());
        assets.add(Asset.builder().id(36).name("MacBook-Pro").price(2_00_000).build());
        assets.add(Asset.builder().id(37).name("Dell-Inspiron").price(45_000).build());
        assets.add(Asset.builder().id(38).name("HP-Elite").price(65_000).build());
    }

    @Override
    public Asset saveAsset(Asset asset) {
        assets.add(asset);
        return asset;
    }

    @Override
    public void updateAsset(long assetId, Asset asset) {
        Optional<Asset> optionalAsset = assets.stream().filter(asset1 -> asset1.getId() == assetId).findFirst();
        optionalAsset.ifPresent(asset1 -> {
            asset1.setName(asset.getName());
            asset1.setPrice(asset.getPrice());
        });
    }

    @Override
    public void deleteAsset(long assetId) {
        assets.removeIf(asset -> asset.getId() == assetId);

    }

    @Override
    public List<Asset> listAll() {
        return assets;
    }

    @Override
    public Asset findByAssetId(long assetId) {
        Optional<Asset> optionalAsset = assets.stream().filter(asset1 -> asset1.getId() == assetId).findFirst();
        return optionalAsset.orElseThrow(() -> new IllegalArgumentException("Asset Id is not valid"));
    }
}