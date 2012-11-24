package postageapp.params;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageParams extends HashMap<String, Object> {
    private String from, subject, template, recipientOverride, uid;
    private List<String> recipients;
    private Map<String, String> variables, content;
    private Map<String, Map<String, String>> attachments;

    public MessageParams() {
        this.variables = new HashMap<String, String>();
        this.content = new HashMap<String, String>();
        this.attachments = new HashMap<String, Map<String, String>>();
    }

    public MessageParams setUid(String uid) {
        this.uid = uid;
        return this;
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

    public MessageParams setVariable(String name, String value) {
        this.variables.put(name, value);
        return this;
    }

    public MessageParams setContentType(String type, String description) {
        this.content.put(type, description);
        return this;
    }

    public MessageParams setMessageRecipientOverride(String email) {
        this.recipientOverride = email;
        return this;
    }

    public MessageParams addAttachment(String name, String contentType, String content) {
        Map<String, String> attachment = new HashMap<String, String>();
        attachment.put("content_type", contentType);
        attachment.put("content", content);

        this.attachments.put(name, attachment);
        return this;
    }

    @Override
    public String toString() {
        // Construct a Json string instead of a normal map string
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
