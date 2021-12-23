package by.epamtc.stanislavmelnikov.dao.factory;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.dao.parserabstract.AbstractFlowerBuilder;
import by.epamtc.stanislavmelnikov.dao.parserimpl.DOM.FlowerDOMBuilder;
import by.epamtc.stanislavmelnikov.dao.parserimpl.SAX.FlowerSAXBuilder;
import by.epamtc.stanislavmelnikov.dao.parserimpl.STAX.FlowerStaxBuilder;

import java.util.HashMap;
import java.util.Map;

public class DaoBuilderFactory {
    private Map<ParserType, AbstractFlowerBuilder> builders = new HashMap<>();
    private final static DaoBuilderFactory instance = new DaoBuilderFactory();

    public static DaoBuilderFactory getInstance() {
        return instance;
    }

    public void setBuilders(ParserType parserType, AbstractFlowerBuilder builder) {
        builders.put(parserType, builder);
    }

    public DaoBuilderFactory() {
        builders.put(ParserType.DOM, new FlowerDOMBuilder());
        builders.put(ParserType.SAX, new FlowerSAXBuilder());
        builders.put(ParserType.STAX, new FlowerStaxBuilder());
    }

    public AbstractFlowerBuilder createFlowerBuilder(String type) throws DaoException {
        ParserType parserType;
        try {
            parserType = ParserType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DaoException("No such parser type", e);
        }
        return builders.get(parserType);
    }
}
