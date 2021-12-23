package by.epamtc.stanislavmelnikov.logic.factory;

import by.epamtc.stanislavmelnikov.logic.logicimpl.ParserLogicImpl;
import by.epamtc.stanislavmelnikov.logic.logicinterface.ParserLogic;

public class LogicFactory {
    private static final LogicFactory instance = new LogicFactory();
    ParserLogic parserLogic = new ParserLogicImpl();
    private LogicFactory() {

    }
    public static LogicFactory getInstance() {
        return instance;
    }

    public ParserLogic getParserLogic() {
        return parserLogic;
    }

    public void setParserLogic(ParserLogic parserLogic) {
        this.parserLogic = parserLogic;
    }
}