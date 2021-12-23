package by.epamtc.stanislavmelnikov.dao.parserimpl.DOM;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.dao.parserabstract.AbstractFlowerBuilder;
import by.epamtc.stanislavmelnikov.entity.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlowerDOMBuilder extends AbstractFlowerBuilder {
    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder documentBuilder;

    public FlowerDOMBuilder() {
        flowers = new ArrayList<>();
    }

    @Override
    public void buildSetFlowers(String xmlPath) throws DaoException {
        try {
            dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File(xmlPath));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("flower");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DaoException("cannot parse document - DOM", e);
        }
    }


    public Flower buildFlower(Element element) {
        String idStr = element.getAttribute("id");
        String name = getTextContent(element, "name");
        String soil = getTextContent(element, "soil");
        String origin = getTextContent(element, "origin");
        Element visualParamsElement = getElement(element, "visual-parameters");
        String stemColor = getTextContent(visualParamsElement, "stem-color");
        String leavesColor = getTextContent(visualParamsElement, "leaves-color");
        String avgSize = getTextContent(visualParamsElement, "average-flower-size");
        String multiplying = getTextContent(element, "multiplying");
        String recDateTime = getTextContent(element, "record-date-time");
        Element growingTipsElement = getElement(element, "growing-tips");
        String temperature = getTextContent(growingTipsElement, "temperature");
        String lighting = getTextContent(growingTipsElement, "lighting");
        String watering = getTextContent(growingTipsElement, "watering");
        Flower flower = setFields(idStr, name, soil, origin, stemColor, leavesColor, avgSize, multiplying, recDateTime,
                temperature, lighting, watering);
        return flower;
    }

    public String getTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    public Element getElement(Element element, String tagName) {
        return (Element) element.getElementsByTagName(tagName).item(0);
    }

    private Flower setFields(String idStr, String name, String soil, String origin, String stemColor,
                             String leavesColor, String avgSize, String multiplying, String recDateTime,
                             String temperature, String lighting, String watering) {
        Flower flower = new Flower();
        flower.setId(idStr);
        flower.setName(name);
        flower.setSoil(soil);
        flower.setOrigin(origin);
        flower.setStemColor(stemColor);
        flower.setLeavesColor(leavesColor);
        flower.setAvgFlowerSize(Integer.parseInt(avgSize));
        flower.setMultiplying(multiplying);
        flower.setTemperature(Integer.parseInt(temperature));
        flower.setLightening(Boolean.parseBoolean(lighting));
        flower.setWatering(Integer.parseInt(watering));
        flower.setRecDateTime(LocalDateTime.parse(recDateTime));
        return flower;
    }
}
