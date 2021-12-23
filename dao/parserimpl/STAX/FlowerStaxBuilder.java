package by.epamtc.stanislavmelnikov.dao.parserimpl.STAX;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.dao.parserabstract.AbstractFlowerBuilder;

import by.epamtc.stanislavmelnikov.entity.Flower;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlowerStaxBuilder extends AbstractFlowerBuilder {
    private Flower currentFlower;
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    public FlowerStaxBuilder(){
        flowers = new ArrayList<>();
    }

    @Override
    public void buildSetFlowers(String xmlPath) throws DaoException {
        Path path = Paths.get(xmlPath);
        XMLStreamReader reader;
        try {
            reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path.toFile()));
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new DaoException("fail to create xml stream reader");
        }
        try {
            while (reader.hasNext()) {
                buildFlower(reader);
            }
        } catch (XMLStreamException e) {
            throw new DaoException("fail in building flower - STAX");
        }
    }

    public void buildFlower(XMLStreamReader reader) throws XMLStreamException {
        int eventType;
        eventType = reader.next();
        if (eventType == XMLEvent.START_ELEMENT) {
            String tagName = reader.getName().getLocalPart();
            switch (tagName) {
                case "flower":
                    currentFlower = new Flower();
                    String id = reader.getAttributeValue(null, "id");
                    currentFlower.setId(id);
                    break;
                case "name":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String name = reader.getText();
                        currentFlower.setName(name);
                    }
                    break;

                case "soil":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String soil = reader.getText();
                        currentFlower.setSoil(soil);
                    }
                    break;

                case "origin":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String origin = reader.getText();
                        currentFlower.setOrigin(origin);
                    }
                    break;

                case "stem-color":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String stemColor = reader.getText();
                        currentFlower.setStemColor(stemColor);
                    }
                    break;
                case "leaves-color":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String leavesColor = reader.getText();
                        currentFlower.setLeavesColor(leavesColor);
                    }
                    break;
                case "average-flower-size":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String avgFlowerSize = reader.getText();
                        currentFlower.setAvgFlowerSize(Integer.parseInt(avgFlowerSize));
                    }
                    break;
                case "temperature":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String temperature = reader.getText();
                        currentFlower.setTemperature(Integer.parseInt(temperature));
                    }
                    break;
                case "lighting":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String lighting = reader.getText();
                        currentFlower.setLightening(Boolean.parseBoolean(lighting));
                    }
                    break;
                case "watering":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String watering = reader.getText();
                        currentFlower.setWatering(Integer.parseInt(watering));
                    }
                    break;
                case "multiplying":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String multiplying = reader.getText();
                        currentFlower.setMultiplying((multiplying));
                    }
                    break;
                case "record-date-time":
                    eventType = reader.next();
                    if (eventType == XMLEvent.CHARACTERS) {
                        String recDateTime = reader.getText();
                        currentFlower.setRecDateTime(LocalDateTime.parse(recDateTime));
                    }
                    break;
            }
        }
        if (eventType == XMLEvent.END_ELEMENT) {
            String tag = reader.getName().getLocalPart();
            if (tag.equals("flower")) {
                flowers.add(currentFlower);
            }
        }
    }
}
