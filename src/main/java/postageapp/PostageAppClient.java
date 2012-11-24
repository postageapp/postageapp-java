package postageapp;

import java.util.List;
import java.util.Map;

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
    public void sendMessage(MessageParams message);

    public int getMessageReceipt(String messageUid);

    public List<String> getMethodList();

    public AccountInfo getAccountInfo();

    public ProjectInfo getProjectInfo();

    public List<Message> getMessages();

    public Map<String, MessageTransmission> getMessageTransmissions(String messageUid);

    public Map<ProjectMetrics.WHEN, ProjectMetrics> getMetrics();
}
