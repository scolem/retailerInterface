package com.example.ws.retailerinterface.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
@ComponentScan(basePackageClasses =
{MyWSConfig.class})
public class MyWSConfig extends WsConfigurerAdapter
{
	public MyWSConfig(WSSoapMessageLogger wsSoapMessageLogger)
	{
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
	{
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "/ExampleWS/*");
		servletRegistrationBean.setName("MyWS");

		return servletRegistrationBean;
	}

	@Bean(name = "MyWS")
	public Wsdl11Definition defaultWsdl11Definition()
	{
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("MyWS.wsdl"));
		return wsdl11Definition;
	}
}
