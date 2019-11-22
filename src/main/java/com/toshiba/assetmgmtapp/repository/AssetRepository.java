package com.toshiba.assetmgmtapp.repository;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}