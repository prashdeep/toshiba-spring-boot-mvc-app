package com.toshiba.assetmgmtapp.service;

import com.toshiba.assetmgmtapp.dao.AssetDAO;
import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetDAO;

    //public AssetServiceImpl(@Qualifier("inmemory") AssetDAO assetDAO)  - Using @Qualifier
    public AssetServiceImpl(AssetRepository assetDAO) {
        this.assetDAO = assetDAO;
    }

    @Override
    public Asset saveAsset(Asset asset) {
        return assetDAO.save(asset);
    }

    @Override
    public void updateAsset(long assetId, Asset asset) {
        assetDAO.save(asset);
    }

    @Override
    public void deleteAsset(long assetId) {
        Optional<Asset> optionalAsset = this.assetDAO.findById(assetId);
        optionalAsset.ifPresent((asset )->this.assetDAO.delete(asset));
    }

    @Override
    public List<Asset> listAll() {
        return this.assetDAO.findAll();
    }

    @Override
    public Asset findByAssetId(long assetId) {
        return this.assetDAO.findById(assetId).orElseThrow(() -> new IllegalArgumentException("Asset not present"));
    }
}