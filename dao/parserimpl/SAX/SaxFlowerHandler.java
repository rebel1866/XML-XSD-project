package by.epamtc.stanislavmelnikov.dao.parserimpl.SAX;

import by.epamtc.stanislavmelnikov.entity.Flower;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaxFlowerHandler extends DefaultHandler {
    private List<Flower> flowers;
    private Flower currentFlower;
    private FlowerEnum currentEnum;

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("flowers")) {
            flowers = new ArrayList<>();
        }
        if (qName.equals("flower")) {
            currentFlower = new Flower();
            String id = attributes.getValue("id");
            currentFlower.setId(id);
        }
        if (!qName.equals("flowers") && !qName.equals("flower")) {
            String val = qName.toUpperCase().replace("-", "_");
                currentEnum = FlowerEnum.valueOf(val);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("flower")) {
            flowers.add(currentFlower);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentEnum != FlowerEnum.DEFAULT && currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    currentFlower.setName(value);
                    break;
                case SOIL:
                    currentFlower.setSoil(value);
                    break;
                case ORIGIN:
                    currentFlower.setOrigin(value);
                    break;
                case STEM_COLOR:
                    currentFlower.setStemColor(value);
                    break;
                case LEAVES_COLOR:
                    currentFlower.setLeavesColor(value);
                    break;
                case AVERAGE_FLOWER_SIZE:
                    currentFlower.setAvgFlowerSize(Integer.parseInt(value));
                    break;
                case TEMPERATURE:
                    currentFlower.setTemperature(Integer.parseInt(value));
                    break;
                case LIGHTING:
                    currentFlower.setLightening(Boolean.parseBoolean(value));
                    break;
                case WATERING:
                    currentFlower.setWatering(Integer.parseInt(value));
                    break;
                case MULTIPLYING:
                    currentFlower.setMultiplying(value);
                    break;
                case RECORD_DATE_TIME:
                    currentFlower.setRecDateTime(LocalDateTime.parse(value));
                    break;
            }
        }
        currentEnum = FlowerEnum.DEFAULT;
    }

    enum FlowerEnum {
        NAME,
        SOIL,
        ORIGIN,
        STEM_COLOR,
        LEAVES_COLOR,
        AVERAGE_FLOWER_SIZE,
        TEMPERATURE,
        LIGHTING,
        WATERING,
        MULTIPLYING,
        RECORD_DATE_TIME,
        VISUAL_PARAMETERS,
        GROWING_TIPS,
        FULL_GROWING_TIPS,
        POISONOUS,
        AIR_CLEANING,
        DEFAULT
    }
}
