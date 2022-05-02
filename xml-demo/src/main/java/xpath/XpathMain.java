package xpath;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class XpathMain {

    public static void main(String[] args) {
        // //book[@isbn10="ab12345678"]/title
        try {
            var factory = XPathFactory.newInstance();
            var xpath = factory.newXPath();
//            var expr = xpath.compile("""
//                    book[@isbn10="ab12345678"]/title
//                    """);

            var expr = xpath.compile("""
                    //title
                    """);

            var value = (NodeList) expr.evaluate(
                    new InputSource(
                            XpathMain.class.getResourceAsStream("/catalog.xml")),
                    XPathConstants.NODESET);

            for (int i = 0; i < value.getLength(); i++) {
                var title = (Element) value.item(i);
                System.out.println(title.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
