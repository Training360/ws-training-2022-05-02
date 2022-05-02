package stax;

import javax.xml.stream.XMLOutputFactory;
import java.nio.file.Files;
import java.nio.file.Path;

public class CursorWriterApi {

    public static void main(String[] args) {

        try {
            var factory = XMLOutputFactory.newInstance();
            var writer = factory.createXMLStreamWriter(Files.newBufferedWriter(Path.of("messages.xml")));

            writer.writeStartDocument();
            writer.writeStartElement("messages");

            writer.writeStartElement("message");
            writer.writeCharacters("Hello");
            writer.writeEndElement();

            writer.writeStartElement("message");
            writer.writeCharacters("Word");
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
