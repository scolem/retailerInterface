package com.example.ws.retailerinterface.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.ws.retailerinterface.ws.MyWSConfig;

@ComponentScan(basePackageClasses = {RetailerInterfaceConfig.class, MyWSConfig.class})
@Configuration
@EnableAsync
public class RetailerInterfaceConfig
{
}