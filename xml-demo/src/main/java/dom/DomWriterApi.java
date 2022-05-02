package dom;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class DomWriterApi {

    public static void main(String[] args) {
        try {
            var factory = DocumentBuilderFactory.newDefaultInstance();
            var builder = factory.newDocumentBuilder();
            var document = builder.newDocument();

            var root = document.createElement("messages");
            document.appendChild(root);

            var message1 = document.createElement("message");
            message1.appendChild(document.createTextNode("Hello"));
            root.appendChild(message1);

            var message2 = document.createElement("message");
            message2.appendChild(document.createTextNode("World"));
            root.appendChild(message2);

            var transformerFactory = TransformerFactory.newInstance();
            var transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            var source = new DOMSource(document);
            var writer = new StringWriter();
            var result = new StreamResult(writer);
            transformer.transform(source, result);

            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
