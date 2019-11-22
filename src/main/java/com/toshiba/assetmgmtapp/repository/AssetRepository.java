package com.toshiba.assetmgmtapp.repository;

import com.toshiba.assetmgmtapp.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    //@Query("select * from Asset  where name=:name and price = :price ")
    Optional<Asset> findByNameAndPriceOrderByName(String name, double price);
}