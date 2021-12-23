package by.epamtc.stanislavmelnikov.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileUploader {
    private static final String maxFileKey = "max.file.size";
    private static final String maxMemKey = "max.mem.size";
    private static final String filePathKey = "file.path";
    private static final String tempRepKey = "temp.rep";
    private static final String xsdExtension = "xsd";
    private static final String xmlExtension = "xml";
    private static File file;

    public static Map<String, String> uploadFiles(HttpServletRequest request) throws FileUploadException, IOException {
        String filePath = PropertyLoader.getProperty(filePathKey);
        Map<String, String> params = new HashMap<>();
        ServletFileUpload upload = initUpload();
        List fileItems = upload.parseRequest(request);
        Iterator iterator = fileItems.iterator();
        while (iterator.hasNext()) {
            FileItem fileItem = (FileItem) iterator.next();
            if (!fileItem.isFormField()) {
                String fileName = fileItem.getName();
                file = new File(filePath + fileName);
                try {
                    fileItem.write(file);
                } catch (FileExistsException e) {
                    Logger logger = LogManager.getLogger(FileUploader.class);
                    logger.info("uploaded file already exists, going to use the existing one");
                } catch (FileNotFoundException e) {
                    throw new FileUploadException("Files are not uploaded. Try again.", e);
                } catch (Exception e) {
                    throw new FileUploadException("File uploading fail", e);
                }
                String path = file.getAbsolutePath();
                if (path.endsWith(xsdExtension)) {
                    params.put(xsdExtension, path);
                } else {
                    params.put(xmlExtension, path);
                }
            } else {
                params.put("parserType", fileItem.getString());
            }
        }
        return params;
    }

    public static ServletFileUpload initUpload() throws IOException {
        long maxFileSize = Long.parseLong(PropertyLoader.getProperty(maxFileKey));
        int maxMemSize = Integer.parseInt(PropertyLoader.getProperty(maxMemKey));
        String tempRep = PropertyLoader.getProperty(tempRepKey);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File(tempRep));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);
        return upload;
    }
}
