package postageapp;

import java.util.List;

import postageapp.models.*;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostageAppClient {
    public void sendMessage();

    public int getMessageReceipt();

    public List<String> getMethodList();

    public AccountInfo getAccountInfo();

    public ProjectInfo getProjectInfo();

    public List<Message> getMessages();

    public List<MessageTransmission> getMessageTransmissions();

    public ProjectMetrics getMetrics();
}
