package com.toshiba.assetmgmtapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AssetMgmtAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetMgmtAppApplication.class, args);
	}

}
