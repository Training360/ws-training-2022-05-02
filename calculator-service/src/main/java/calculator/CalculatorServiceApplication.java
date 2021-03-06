package calculator;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class CalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorServiceApplication.class, args);
	}

	@Value("${published.endpoint}")
	private String publishedEndpoint;

	@Bean
	public Endpoint calculatorEndpoint(Bus bus) {
		var calculator = new DefaultCalculatorEndpoint();
		var endpoint = new EndpointImpl(bus, calculator);
		//endpoint.setPublishedEndpointUrl(publishedEndpoint);
		endpoint.publish("/calculator");
		return endpoint;
	}

}
