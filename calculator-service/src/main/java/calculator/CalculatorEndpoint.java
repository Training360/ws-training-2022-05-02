package calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://training360.com/schemas/calculator")
public interface CalculatorEndpoint {
    @WebMethod(operationName = "addOperation")
    @WebResult(name = "result")
    CalculatorAddResponse add(@WebParam(name = "arguments") CalculatorAddRequest request);
}
