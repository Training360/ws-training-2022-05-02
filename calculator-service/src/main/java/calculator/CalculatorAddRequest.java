package calculator;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CalculatorAddRequest {

    @XmlElement(name = "number1")
    private int a;

    @XmlElement(name = "number2")
    private int b;

}
