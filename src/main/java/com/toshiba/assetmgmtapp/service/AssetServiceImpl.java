package com.toshiba.assetmgmtapp.service;

import com.toshiba.assetmgmtapp.dao.AssetDAO;
import com.toshiba.assetmgmtapp.model.Asset;
import com.toshiba.assetmgmtapp.repository.AssetRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetDAO;

    @Autowired
    private  DiscoveryClient discoveryClient;


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

    @Override
    public String fetchOrgById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = this.discoveryClient.getInstances("organizationservice").get(0).getUri().toString();
        ResponseEntity<String> response = restTemplate
                .exchange(serviceUrl+"/organization/"+id , HttpMethod.GET, null, String.class);


        return response.getBody();
    }

    public DiscoveryClient getDiscoveryClient() {
        return discoveryClient;
    }

    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
}