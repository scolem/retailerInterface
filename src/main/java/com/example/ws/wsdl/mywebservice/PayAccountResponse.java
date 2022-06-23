
package com.example.ws.wsdl.mywebservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payAccountResponse", propOrder =
{"_return"})
@XmlRootElement
public class PayAccountResponse
{

	@XmlElement(name = "return")
	protected PaymentResponse _return;
}
