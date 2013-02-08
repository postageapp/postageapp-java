package postageapp;

import java.util.List;
import java.util.Map;

import postageapp.http.PostageAppException;
import postageapp.models.*;
import postageapp.params.MessageParams;

public interface PostageAppClient {
    public void setAPIKey(final String apiKey);

    public double sendMessage(MessageParams message) throws PostageAppException;

    public double getMessageReceipt(String messageUid) throws PostageAppException;

    public String[] getMethodList() throws PostageAppException;

    public AccountInfo getAccountInfo() throws PostageAppException;

    public ProjectInfo getProjectInfo() throws PostageAppException;

    public List<Message> getMessages() throws PostageAppException;

    public MessageTransmissionsResponse getMessageTransmissions(String messageUid) throws PostageAppException;

    public Map<String, Map<String, ProjectMetrics>> getMetrics() throws PostageAppException;

    public List<MessageDeliveryStatus> getMessageDeliveryStatus(String messageUid) throws PostageAppException;
    
    public Map<String, Integer> getMessageStatus(String messageUid) throws PostageAppException;
    
	public Map<String, RecipientInfo> getRecipientsList(String messageUid) throws PostageAppException;    
}
