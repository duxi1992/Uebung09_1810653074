package Aufgabe_3;

import Aufgabe_1.weather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Aufruf
{
    private static final String WEATHER_XML = "C:/temp/UE9/weather_XML.xml";

    public static void main(String[] args)
    {
        weather w2 = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(weather.class);
            System.out.println();
            System.out.println("Output from our XML File: ");
            Unmarshaller um = context.createUnmarshaller();


            w2 = (weather) um.unmarshal(new FileReader(WEATHER_XML));
            System.out.println(w2.toString());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}