package com.example.ws.retailerinterface.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService
{
	@Async
	public void callAsyncMethod() throws InterruptedException
	{
		Thread.sleep(2000);
	}
}
