package Aufgabe_1;
//Bibliotheken werden eingebunden
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Aufruf
{
    private static final String weather_XML = "C:/temp/UE9/weather-jaxb.xml";

    public static void main(String[] args)
    {
        //Aufgabe 1
        String json = "{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}";

        ObjectMapper Weather = new ObjectMapper();
        weather weather = null;
        try
        {
            weather = Weather.readValue(json, weather.class);
            System.out.println(weather.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        //Aufgabe 2


        //create JAXB context and instance Marshaller
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(weather.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Write sout
            m.marshal(weather, System.out);

            //Write to file
            m.marshal(weather, new File(weather_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            context = JAXBContext.newInstance(weather.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Write sout
            m.marshal(weather, System.out);

            //Write to file
            m.marshal(weather, new File(weather_XML));
        } catch (JAXBException e) {
            e.printStackTrace();                        /*Es ist eine Methode auf Exception Instanzen, die druckt den Stack-Trace der Instanz auf System.err.

                                                        Es ist ein sehr einfaches, aber sehr nützliches Werkzeug zum Diagnostizieren von Ausnahmen. Es zeigt Ihnen, was passiert ist und wo im Code das passiert ist.*/
        }
    }


}
