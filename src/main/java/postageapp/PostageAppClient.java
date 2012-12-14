package postageapp;

import java.util.List;
import java.util.Map;

import postageapp.http.PostageAppException;
import postageapp.models.*;
import postageapp.params.MessageParams;

public interface PostageAppClient {
    public void setAPIKey(final String apiKey);

    public long sendMessage(MessageParams message) throws PostageAppException;

    public long getMessageReceipt(String messageUid) throws PostageAppException;

    public String[] getMethodList() throws PostageAppException;

    public AccountInfo getAccountInfo() throws PostageAppException;

    public ProjectInfo getProjectInfo() throws PostageAppException;

    public List<Message> getMessages() throws PostageAppException;

    public MessageTransmissonsResponse getMessageTransmissions(String messageUid) throws PostageAppException;

    public Map<String, Map<String, ProjectMetrics>> getMetrics() throws PostageAppException;
}
