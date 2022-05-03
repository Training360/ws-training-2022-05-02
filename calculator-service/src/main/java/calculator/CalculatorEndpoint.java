package calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://training360.com/schemas/calculator")
public class CalculatorEndpoint {

    @WebMethod
    @WebResult(name = "result")
    public CalculatorAddResponse add(@WebParam(name = "arguments") CalculatorAddRequest request) {
        return new CalculatorAddResponse(request.getA() + request.getB());
    }
}
