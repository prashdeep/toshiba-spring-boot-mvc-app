package com.toshiba.assetmgmtapp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.toshiba.assetmgmtapp.client.OrganizationFeignClient;
import com.toshiba.assetmgmtapp.dao.AssetDAO;
import com.toshiba.assetmgmtapp.events.source.SimpleSourceBean;
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
import java.util.Random;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  DiscoveryClient discoveryClient;

    @Autowired
    private SimpleSourceBean simpleSourceBean;

   // @Autowired
   // private OrganizationFeignClient organizationFeignClient;


    //public AssetServiceImpl(@Qualifier("inmemory") AssetDAO assetDAO)  - Using @Qualifier
    public AssetServiceImpl(AssetRepository assetDAO) {
        this.assetDAO = assetDAO;
    }

    @Override
    public Asset saveAsset(Asset asset) {
        this.simpleSourceBean.publishOrgChange(asset);
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
   // @HystrixCommand
    public String fetchOrgById(long id) {

        //Naive way of implementing the discovery client
        //RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = this.discoveryClient.getInstances("organizationservice").get(0).getUri().toString();
        ResponseEntity<String> response = this.restTemplate
                .exchange(serviceUrl+"/v1/organization/"+id , HttpMethod.GET, null, String.class);
        return response.getBody();
        //return fetchOrganizationWithRibbon(id);
        // return organizationFeignClient.getOrganizationById(id).toString();
    }

    public String fetchOrganizationWithRibbon(long id){
        latency();
        //  Use Ribbon for LoadBalancing
        ResponseEntity<String> response = this.restTemplate.exchange("http://organizationservice/v1/organization/"+id,HttpMethod.GET, null, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        return response.getBody();
    }

    public String fallbackMethod(long id){
        return "Default message";
    }

    private void latency(){
        Random random = new Random();
        int value = random.nextInt(3) + 1;
        if (value == 3){
            System.out.println("*************");
            System.out.println("Came inside ");
            System.out.println("*************");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public DiscoveryClient getDiscoveryClient() {
        return discoveryClient;
    }

    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
}