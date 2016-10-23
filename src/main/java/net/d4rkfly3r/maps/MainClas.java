package net.d4rkfly3r.maps;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Paths;

public class MainClas {
    public static void main(String[] args) {
        Loader loader;
        try {
            loader = new Loader(Paths.get("xmls").resolve("map.xml"));
            loader.parse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
