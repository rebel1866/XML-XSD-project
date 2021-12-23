package by.epamtc.stanislavmelnikov.logic.logicinterface;

import by.epamtc.stanislavmelnikov.entity.Flower;
import by.epamtc.stanislavmelnikov.logic.exception.LogicException;

import java.util.List;

public interface ParserLogic {
     List<Flower> findFlowers(String parserType, String xmlPath) throws LogicException;
}
