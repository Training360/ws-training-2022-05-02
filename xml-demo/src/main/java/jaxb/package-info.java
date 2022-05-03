@XmlSchema(
        elementFormDefault= XmlNsForm.QUALIFIED,
        namespace="https://training360.com/schemas/catalog",
        xmlns={@XmlNs(prefix="c",
                namespaceURI="https://training360.com/schemas/catalog")}
)
package jaxb;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;