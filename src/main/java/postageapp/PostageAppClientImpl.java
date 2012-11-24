package postageapp;

import com.google.gson.Gson;
import org.apache.http.client.utils.URIBuilder;
import postageapp.http.PostageAppHttpClient;
import postageapp.models.*;
import postageapp.params.MessageParams;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostageAppClientImpl implements PostageAppClient {
    private String apiVersion;

    private String API_HOST = "api.postageapp.com";

    private static final class Endpoints {
        static final String SEND_MESSAGE = "send_message";
        static final String GET_MESSAGE_RECEIPT = "get_message_receipt";
        static final String GET_METHOD_LIST = "get_method_list";
        static final String GET_ACCOUNT_INFO = "get_account_info";
        static final String GET_PROJECT_INFO = "get_project_info";
        static final String GET_MESSAGES = "get_messages.json";
        static final String GET_MESSAGE_TRANSMISSIONS = "get_message_transmissions";
        static final String GET_METRICS = "get_metrics";
    }

    private String apiKey;
    private PostageAppHttpClient httpClient;

    public PostageAppClientImpl(String apiKey) {
        this.apiKey = apiKey;
        this.apiVersion = "v.1.0";
    }

    @Override
    public void sendMessage(MessageParams params) {
        this.sendRequest(Endpoints.SEND_MESSAGE, params.toString());
    }

    @Override
    public int getMessageReceipt(String messageUid) {
        this.sendRequest(Endpoints.GET_MESSAGE_RECEIPT, this.messageUidRequestString(messageUid));
        return 0;
    }

    @Override
    public List<String> getMethodList() {
        this.sendRequest(Endpoints.GET_METHOD_LIST, this.apiKeyRequestString());
        return null;
    }

    @Override
    public AccountInfo getAccountInfo() {
        this.sendRequest(Endpoints.GET_ACCOUNT_INFO, this.apiKeyRequestString());
        return null;
    }

    @Override
    public ProjectInfo getProjectInfo() {
        this.sendRequest(Endpoints.GET_PROJECT_INFO, this.apiKeyRequestString());
        return null;
    }

    @Override
    public List<Message> getMessages() {
        this.sendRequest(Endpoints.GET_MESSAGES, this.apiKeyRequestString());
        return null;
    }

    @Override
    public  Map<String, MessageTransmission> getMessageTransmissions(String messageUid) {
        Map<String, MessageTransmission> transmissions = new HashMap<String, MessageTransmission>();
        this.sendRequest(Endpoints.GET_MESSAGE_TRANSMISSIONS, this.messageUidRequestString(messageUid));
        return transmissions;
    }

    @Override
    public Map<ProjectMetrics.WHEN, ProjectMetrics> getMetrics() {
        this.sendRequest(Endpoints.GET_METRICS, this.apiKeyRequestString());
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    // Since these requests are so small, don't bother creating builders / params for them
    private String apiKeyRequestString() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apiKey", this.apiKey);
        return new Gson().toJson(params);
    }

    private String messageUidRequestString(String messageUid) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apiKey", this.apiKey);
        params.put("uid", messageUid);
        return new Gson().toJson(params);
    }

    private String sendRequest(String endpoint, String content) {
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost(API_HOST)
                .setPath(this.apiVersion + '/' + endpoint);

        try {
            return this.httpClient.post(uriBuilder.build().toString(), content);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
