package Aufgabe_4;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Aufruf
{
    private static final String WEATHER_XML = "C:/temp/UE9/weather-jaxb_exclusion.xml";
    public static void main(String[] args)
    {
        String json = "{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}";

        ObjectMapper om = new ObjectMapper();
        Aufgabe_4.weather weather = null;
        try
        {
            weather = om.readValue(json, Aufgabe_4.weather.class);
            System.out.println(weather.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        //create JAXB context and instance Marshaller
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(weather.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Write sout
            m.marshal(weather, System.out);

            //Write to file
            m.marshal(weather, new File(WEATHER_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}