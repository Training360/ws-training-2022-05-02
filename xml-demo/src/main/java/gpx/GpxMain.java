package gpx;

import com.topografix.gpx._1._1.GpxType;
import jaxb.JaxbReaderMain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

public class GpxMain {

    public static void main(String[] args) {
        try {
            var context = JAXBContext.newInstance(GpxType.class);
            var unmarshaller = context.createUnmarshaller();

            var gpx = ((JAXBElement<GpxType>)
                    unmarshaller.unmarshal(JaxbReaderMain.class.getResourceAsStream("/Afternoon_Ride.gpx")))
                    .getValue();

            var points = gpx.getTrk().get(0).getTrkseg().get(0).getTrkpt();

            for (var point: points) {
                System.out.println(point.getLat() + "," + point.getLon());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
