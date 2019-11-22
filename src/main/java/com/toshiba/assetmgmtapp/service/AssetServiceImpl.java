package com.toshiba.assetmgmtapp.service;

import com.toshiba.assetmgmtapp.dao.AssetDAO;
import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetDAO assetDAO;

    //public AssetServiceImpl(@Qualifier("inmemory") AssetDAO assetDAO)  - Using @Qualifier
    public AssetServiceImpl(AssetDAO assetDAO) {
        this.assetDAO = assetDAO;
    }

    @Override
    public Asset saveAsset(Asset asset) {
        return assetDAO.saveAsset(asset);
    }

    @Override
    public void updateAsset(long assetId, Asset asset) {
        assetDAO.updateAsset(assetId,asset);
    }

    @Override
    public void deleteAsset(long assetId) {
        this.assetDAO.deleteAsset(assetId);
    }

    @Override
    public List<Asset> listAll() {
        return this.assetDAO.listAll();
    }

    @Override
    public Asset findByAssetId(long assetId) {
        return this.assetDAO.findByAssetId(assetId);
    }
}