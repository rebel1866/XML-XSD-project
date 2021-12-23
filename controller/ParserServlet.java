package by.epamtc.stanislavmelnikov.controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.stanislavmelnikov.entity.Flower;
import by.epamtc.stanislavmelnikov.logic.exception.LogicException;
import by.epamtc.stanislavmelnikov.logic.factory.LogicFactory;
import by.epamtc.stanislavmelnikov.logic.logicinterface.ParserLogic;
import by.epamtc.stanislavmelnikov.logic.schemevalidation.SchemeValidation;
import by.epamtc.stanislavmelnikov.utils.FileUploader;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogicFactory logicFactory = LogicFactory.getInstance();
        ParserLogic parserLogic = logicFactory.getParserLogic();
        List<Flower> flowers;
        Map<String, String> params;
        Logger logger = LogManager.getLogger(ParserServlet.class);
        try {
            params = FileUploader.uploadFiles(request);
        } catch (FileUploadException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        String xsdPath = params.get("xsd");
        String xmlPath = params.get("xml");
        String parserType = params.get("parserType");
        try {
            SchemeValidation.validateXMLSchema(xsdPath, xmlPath);
        } catch (LogicException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        try {
            flowers = parserLogic.findFlowers(parserType, xmlPath);
        } catch (LogicException e) {
            logger.error(e.getMessage(), e);
            throw new ServletException(e.getMessage(), e);
        }
        request.setAttribute("flowers", flowers);
        request.getRequestDispatcher("flowers.jsp").forward(request, response);
    }
}