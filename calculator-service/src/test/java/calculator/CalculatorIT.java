package calculator;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorIT {

    @LocalServerPort
    private int port;

    @Test
    void testAdd() {
        var factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(DefaultCalculatorEndpoint.class);
        factory.setAddress(String.format("http://localhost:%s/services/calculator", port));
        var endpoint = factory.create(CalculatorEndpoint.class);

        var request = new CalculatorAddRequest(10, 15);
        var response = endpoint.add(request);

        assertEquals(25, response.getResult());
    }
}
