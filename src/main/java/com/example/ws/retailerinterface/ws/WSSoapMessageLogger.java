package com.example.ws.retailerinterface.ws;

import com.example.ws.retailerinterface.spring.AsyncService;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

@Component
public class WSSoapMessageLogger implements EndpointInterceptor
{
	public WSSoapMessageLogger(
//	 AsyncService asyncService
	)
	{
	}

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
	{
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint)
	{
		return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
	{
		return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex)
	{
	}
}
