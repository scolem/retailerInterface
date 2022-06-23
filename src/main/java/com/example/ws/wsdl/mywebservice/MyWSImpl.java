
package com.example.ws.wsdl.mywebservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "MyWS", targetNamespace = "http://example.com/")
public interface MyWSImpl
{

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "payAccount", targetNamespace = "http://example.com/",
		className = "com.example.ws.wsdl.mywebservice.PayAccount")
	@ResponseWrapper(localName = "payAccountResponse", targetNamespace = "http://example.com/",
		className = "com.example.ws.wsdl.mywebservice.PayAccountResponse")
	@Action(input = "http://example.com/MyWS/payAccountRequest", output = "http://example.com/MyWS/payAccountResponse")
	PaymentResponse payAccount();
}