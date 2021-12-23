package by.epamtc.stanislavmelnikov.logic.logicimpl;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.dao.factory.DaoBuilderFactory;
import by.epamtc.stanislavmelnikov.dao.parserabstract.AbstractFlowerBuilder;
import by.epamtc.stanislavmelnikov.entity.Flower;
import by.epamtc.stanislavmelnikov.logic.exception.LogicException;
import by.epamtc.stanislavmelnikov.logic.logicinterface.ParserLogic;

import java.util.List;

public class ParserLogicImpl implements ParserLogic {
    @Override
    public List<Flower> findFlowers(String parserType, String xmlPath) throws LogicException {
        DaoBuilderFactory daoBuilderFactory = DaoBuilderFactory.getInstance();
        AbstractFlowerBuilder flowerBuilder;
        try {
            flowerBuilder = daoBuilderFactory.createFlowerBuilder(parserType);
        } catch (DaoException e) {
            throw new LogicException(e.getMessage(), e);
        }
        try {
            flowerBuilder.buildSetFlowers(xmlPath);
        } catch (DaoException e) {
            throw new LogicException(e.getMessage(), e);
        }
        List<Flower> flowers = flowerBuilder.getFlowers();
        return flowers;
    }
}
