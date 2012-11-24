package postageapp.params;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageParams extends HashMap<String, Object> {
    private String from;
    private String subject;
    private List<String> recipients;
    private String template;

    public MessageParams() {

    }

    public MessageParams setRecipients(List<String> recipients) {
        this.recipients = recipients;
        return this;
    }

    public MessageParams setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public MessageParams setFrom(String from) {
        this.from = from;
        return this;
    }

    public MessageParams setTemplate(String templateName) {
        this.template = templateName;
        return this;
    }

    @Override
    public String toString() {
        // Construct a Json string instead of a normal map string
        String json = "";
        return json;
    }
}
