package com.toshiba.assetmgmtapp.dao;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mysql")
//@Profile("prod")
@Primary
public class MySQLAssetDAOImpl implements AssetDAO {



    @Override
    public Asset saveAsset(Asset asset) {
        return null;
    }

    @Override
    public void updateAsset(long assetId, Asset asset) {

    }

    @Override
    public void deleteAsset(long assetId) {

    }

    @Override
    public List<Asset> listAll() {
        return null;
    }

    @Override
    public Asset findByAssetId(long assetId) {
        return null;
    }
}