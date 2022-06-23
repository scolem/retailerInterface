package com.example.ws.retailerinterface.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {RetailerInterfaceConfig.class})
public class RetailerInterfaceStarter
{
	public static void main(String[] args)
	{
		SpringApplication.run(RetailerInterfaceStarter.class, args);
	}
}
