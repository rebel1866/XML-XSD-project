package by.epamtc.stanislavmelnikov.dao.parserimpl.SAX;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.dao.parserabstract.AbstractFlowerBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
public class FlowerSAXBuilder extends AbstractFlowerBuilder {
    private final static SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    private SaxFlowerHandler saxFlowerHandler;
    private XMLReader xmlReader;

    public FlowerSAXBuilder() {
        saxFlowerHandler = new SaxFlowerHandler();
    }

    @Override
    public void buildSetFlowers(String xmlPath) throws DaoException {
        try {
            SAXParser parser = parserFactory.newSAXParser();
            xmlReader = parser.getXMLReader();
            xmlReader.setContentHandler(saxFlowerHandler);
            xmlReader.parse(xmlPath);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new DaoException("parser configuration fail", e);
        }
        flowers = saxFlowerHandler.getFlowers();
    }
}
