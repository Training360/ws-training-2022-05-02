package xslt;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.nio.file.Files;
import java.nio.file.Path;

public class XsltApi {

    public static void main(String[] args) {
        try {
            var factory = TransformerFactory.newInstance();
            var transformer = factory.newTransformer(
                    new StreamSource(XsltApi.class.getResourceAsStream("/catalog.xslt")));
            var source = new StreamSource(XsltApi.class.getResourceAsStream("/catalog.xml"));
            var result = new StreamResult(Files.newBufferedWriter(Path.of("catalog.html")));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
