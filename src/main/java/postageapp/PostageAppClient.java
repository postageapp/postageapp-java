package postageapp;

import java.util.List;
import java.util.Map;

import postageapp.http.PostageAppException;
import postageapp.models.*;
import postageapp.params.MessageParams;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostageAppClient {
    public long sendMessage(MessageParams message) throws PostageAppException;

    public long getMessageReceipt(String messageUid) throws PostageAppException;

    public String[] getMethodList() throws PostageAppException;

    public AccountInfo getAccountInfo() throws PostageAppException;

    public ProjectInfo getProjectInfo() throws PostageAppException;

    public List<Message> getMessages() throws PostageAppException;

    public MessageTransmissonsResponse getMessageTransmissions(String messageUid) throws PostageAppException;

    public Map<String, Map<String, ProjectMetrics>> getMetrics() throws PostageAppException;
}
