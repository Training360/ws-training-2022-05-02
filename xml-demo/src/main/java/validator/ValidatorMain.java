package validator;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class ValidatorMain {

    public static void main(String[] args) {
        try {
            var factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            var schema = factory.newSchema(
                    new StreamSource(ValidatorMain.class.getResourceAsStream("/catalog.xsd")));

            var validator = schema.newValidator();

            validator.validate(new StreamSource(ValidatorMain.class.getResourceAsStream("/catalogns.xml")));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
