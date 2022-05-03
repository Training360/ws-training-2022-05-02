package calculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CalculatorEndpoint {

    @WebMethod
    public int add(int a, int b) {
        return a + b;
    }
}
