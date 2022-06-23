package com.example.ws.retailerinterface.ws;

import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.ws.retailerinterface.spring.AsyncService;
import com.example.ws.wsdl.mywebservice.PayAccount;
import com.example.ws.wsdl.mywebservice.PayAccountResponse;

@Component
@Endpoint
public class MyWS
{
	public static final String NAMESPACE = "http://example.com/";
	private AsyncService asyncService;

	public MyWS(AsyncService asyncService)
	{
		this.asyncService = asyncService;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "payAccount")
	@ResponsePayload
	public PayAccountResponse payAccount(@RequestPayload PayAccount payAccount) throws InterruptedException
	{
		asyncService.callAsyncMethod();
		return new PayAccountResponse();
	}
}
