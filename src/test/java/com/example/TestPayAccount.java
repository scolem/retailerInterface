package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.OffsetDateTime;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.ws.retailerinterface.spring.AsyncService;
import com.example.ws.retailerinterface.spring.RetailerInterfaceConfig;
import com.example.ws.wsdl.mywebservice.MyWSImpl;
import com.example.ws.wsdl.mywebservice.PaymentResponse;

@SpringBootTest(classes = {RetailerInterfaceConfig.class,}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties =
{"server.port=8000"})
public class TestPayAccount
{
	@Autowired
	private AsyncService asyncService;

	@Test
	public void nullResponse()
	{
		OffsetDateTime start = OffsetDateTime.now();
		MyWSImpl myWS = getMyWSService();

		PaymentResponse paymentResponse = myWS.payAccount();

		long duration = Duration.between(start, OffsetDateTime.now()).toMillis();
		assertTrue(duration < 2000, "Wanted < 2000 but was %s".formatted(duration));
	}

	@Test
	public void testAsyncService() throws InterruptedException
	{
		OffsetDateTime start = OffsetDateTime.now();

		asyncService.callAsyncMethod();

		long duration = Duration.between(start, OffsetDateTime.now()).toMillis();
		assertTrue(duration < 2000, "Wanted < 2000 but was %s".formatted(duration));
	}

	public MyWSImpl getMyWSService()
	{
		try
		{
			QName myWSPortQN = new QName("http://example.com/", "MyWSPort");
			Service myWSService = null;

			myWSService = Service.create(new URL(WS_TEST_ENDPOINT), new QName("http://example.com/", "MyWS"));

			MyWSImpl myWS = myWSService.getPort(myWSPortQN, MyWSImpl.class);

			return myWS;
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static final String WS_TEST_ENDPOINT = "http://localhost:8000/ExampleWS/MyWS.wsdl";
}
