package by.epamtc.stanislavmelnikov.dao.parserabstract;

import by.epamtc.stanislavmelnikov.dao.exception.DaoException;
import by.epamtc.stanislavmelnikov.entity.Flower;

import java.util.List;

public abstract class AbstractFlowerBuilder {
    protected List<Flower> flowers;

    abstract public void buildSetFlowers(String xmlPath) throws DaoException;


    public List<Flower> getFlowers() {
        return flowers;
    }
}

