package postageapp.params;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageParams extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	private String template, recipientOverride, uid;
    private List<String> recipients;
    private Map<String, String> variables, content, headers;
    private Map<String, Map<String, String>> attachments;
    private final Gson gson = new Gson();

    public MessageParams() {
        this.variables = new HashMap<String, String>();
        this.content = new HashMap<String, String>();
        this.attachments = new HashMap<String, Map<String, String>>();
        this.headers = new HashMap<String, String>();
    }

    public MessageParams setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public MessageParams setRecipients(List<String> recipients) {
        this.recipients = recipients;
        return this;
    }

    public MessageParams addHeader(String name, String text) {
        this.headers.put(name, text);
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

    public MessageParams addContentType(String type, String description) {
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

    public String buildRequest(String apiKey) {
        // Construct a Json string instead of a normal map string
        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("recipients", this.recipients);
        mappedParams.put("headers", this.headers);
        mappedParams.put("content", this.content);
        mappedParams.put("attachments", this.attachments);
        mappedParams.put("template", this.template);
        mappedParams.put("variables", this.variables);
        mappedParams.put("recipient_override", this.recipientOverride);

        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("api_key", apiKey);
        requestMap.put("arguments", mappedParams);
        requestMap.put("uid", this.uid);
        
        return gson.toJson(requestMap, mapType);
    }
}
