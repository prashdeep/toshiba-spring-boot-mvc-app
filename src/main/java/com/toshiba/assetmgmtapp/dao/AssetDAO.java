package com.toshiba.assetmgmtapp.dao;

import com.toshiba.assetmgmtapp.model.Asset;
import java.util.List;

public interface AssetDAO {

    Asset saveAsset(Asset asset);

    void updateAsset(long assetId, Asset asset);

    void deleteAsset(long assetId);

    List<Asset> listAll();

    Asset findByAssetId(long assetId);
}