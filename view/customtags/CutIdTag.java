package by.epamtc.stanislavmelnikov.view.customtags;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CutIdTag extends TagSupport {
    private String idValue;
    private static final int cutIndex = 3;

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        String value = idValue.substring(cutIndex);
        try {
            out.print(value);
        } catch (IOException e) {
            Logger logger = LogManager.getLogger(CutIdTag.class);
            logger.error(e.getMessage(), e);
        }
        return SKIP_BODY;
    }
}
