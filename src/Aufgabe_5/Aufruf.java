package Aufgabe_5;
import Aufgabe_1.weather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Aufruf
{
    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper();
        weather w = new weather(50, "Clear", "Sky is clear", "01n");

        try
        {
            String jsonInString = mapper.writeValueAsString(w);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
    }
}