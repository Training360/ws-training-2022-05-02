package lws;

import com.learnwebservices.services.hello.HelloEndpointService;
import com.learnwebservices.services.hello.HelloRequest;

import javax.xml.ws.BindingProvider;

public class HelloMain {

    public static void main(String[] args) {
        var service = new HelloEndpointService();
        var port = service.getHelloEndpointPort();

        var  provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://localhost:8080/services/hello");

        var request = new HelloRequest();
        request.setName("Trainer");

        var response = port.sayHello(request);
        System.out.println(response.getMessage());
    }
}
