package postageapp;

import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import postageapp.http.PostageAppException;
import postageapp.http.PostageAppHttpClient;
import postageapp.http.PostageAppHttpClientImpl;
import postageapp.models.AccountInfo;
import postageapp.models.Message;
import postageapp.models.MessageDeliveryStatus;
import postageapp.models.MessageTransmissionsResponse;
import postageapp.models.ProjectInfo;
import postageapp.models.ProjectMetrics;
import postageapp.models.RecipientInfo;
import postageapp.params.MessageParams;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unchecked")
public class PostageAppClientImpl implements PostageAppClient {
	private final String apiVersion;

	private static final String API_HOST = "api.postageapp.com";

	private static final class Endpoints {
		static final String SEND_MESSAGE = "send_message";
		static final String GET_MESSAGE_RECEIPT = "get_message_receipt";
		static final String GET_METHOD_LIST = "get_method_list";
		static final String GET_ACCOUNT_INFO = "get_account_info";
		static final String GET_PROJECT_INFO = "get_project_info";
		static final String GET_MESSAGES = "get_messages";
		static final String GET_MESSAGE_TRANSMISSIONS = "get_message_transmissions";
		static final String GET_METRICS = "get_metrics";
		static final String MESSAGE_DELIVERY_STATUS = "message_delivery_status";
		static final String MESSAGE_STATUS = "message_status";
		static final String GET_RECIPIENTS_LIST = "get_recipients_list";
	}

	private String apiKey;
	private final PostageAppHttpClient httpClient;
	private final Gson gson;

	public PostageAppClientImpl() {
		this.apiVersion = "v.1.0";
		this.httpClient = new PostageAppHttpClientImpl(new DefaultHttpClient());
		this.gson = new Gson();
	}

	public void setAPIKey(final String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public double sendMessage(MessageParams params) throws PostageAppException {
		checkAPIKey();

		Map<String, Object> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.SEND_MESSAGE, params.buildRequest(this.apiKey)));
		Map<String, Double> message = (Map<String, Double>) data.get("message");
		return message.get("id").doubleValue();
	}

	@Override
	public double getMessageReceipt(String messageUid)
			throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_MESSAGE_RECEIPT,
				this.messageUidRequestString(messageUid)));
		Map<String, Double> message = (Map<String, Double>) data.get("message");
		return message.get("id").doubleValue();
	}

	@Override
	public String[] getMethodList() throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_METHOD_LIST, this.apiKeyRequestString()));
		String methods = (String) data.get("methods");
		return methods.split(", ");
	}

	@Override
	public AccountInfo getAccountInfo() throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_ACCOUNT_INFO, this.apiKeyRequestString()));
		AccountInfo accountInfo = new AccountInfo(
				(Map<String, ?>) data.get("account"));
		return accountInfo;
	}

	@Override
	public ProjectInfo getProjectInfo() throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_PROJECT_INFO, this.apiKeyRequestString()));
		ProjectInfo projectInfo = new ProjectInfo(
				(Map<String, ?>) data.get("project"));
		return projectInfo;
	}

	@Override
	public List<Message> getMessages() throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_MESSAGES, this.apiKeyRequestString()));
		List<Message> messages = new ArrayList<Message>();

		for (String messageUid : data.keySet()) {
			messages.add(new Message(messageUid, (Map<String, ?>) data
					.get(messageUid)));
		}

		return messages;
	}

	@Override
	public MessageTransmissionsResponse getMessageTransmissions(
			String messageUid) throws PostageAppException {
		checkAPIKey();

		Map<String, ?> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_MESSAGE_TRANSMISSIONS,
				this.messageUidRequestString(messageUid)));
		return new MessageTransmissionsResponse(data);
	}

	@Override
	public Map<String, Map<String, ProjectMetrics>> getMetrics()
			throws PostageAppException {
		checkAPIKey();

		Map<String, Object> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_METRICS, this.apiKeyRequestString()));
		Map<String, Object> metrics = (Map<String, Object>) data.get("metrics");
		Map<String, Map<String, ProjectMetrics>> metricsMap = new HashMap<String, Map<String, ProjectMetrics>>();

		String[] metricIntervals = new String[] { "hour", "date", "week",
				"month" };

		for (String interval : metricIntervals) {
			Map<String, Object> intervalResponseMap = (Map<String, Object>) metrics
					.get(interval);

			Map<String, ProjectMetrics> intervalMetrics = new HashMap<String, ProjectMetrics>();

			intervalMetrics
					.put("delivered",
							new ProjectMetrics(
									(Map<String, String>) intervalResponseMap
											.get("delivered")));
			intervalMetrics.put("opened", new ProjectMetrics(
					(Map<String, String>) intervalResponseMap.get("opened")));
			intervalMetrics.put("failed", new ProjectMetrics(
					(Map<String, String>) intervalResponseMap.get("failed")));
			intervalMetrics.put("rejected", new ProjectMetrics(
					(Map<String, String>) intervalResponseMap.get("rejected")));
			intervalMetrics.put("created", new ProjectMetrics(
					(Map<String, String>) intervalResponseMap.get("created")));
			intervalMetrics.put("queued", new ProjectMetrics(
					(Map<String, String>) intervalResponseMap.get("queued")));

			metricsMap.put(interval, intervalMetrics);
		}

		return metricsMap;
	}

	@Override
	public Map<String, RecipientInfo> getRecipientsList(String messageUid)
			throws PostageAppException {
		checkAPIKey();

		Map<String, Object> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.GET_RECIPIENTS_LIST,
				this.messageUidRequestString(messageUid)));

		Map<String, ?> recipients = (Map<String, ?>) data.get("recipients");
		Map<String, RecipientInfo> result = new HashMap<String, RecipientInfo>();

		for (String recipient : recipients.keySet()) {
			result.put(
					recipient,
					new RecipientInfo((Map<String, ?>) recipients
							.get(recipient)));
		}

		return result;
	}

	@Override
	public Map<String, Integer> getMessageStatus(String messageUid)
			throws PostageAppException {
		checkAPIKey();

		Map<String, Object> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.MESSAGE_STATUS,
				this.messageUidRequestString(messageUid)));

		return (Map<String, Integer>) data.get("message_status");
	}

	@Override
	public List<MessageDeliveryStatus> getMessageDeliveryStatus(
			String messageUid) throws PostageAppException {
		checkAPIKey();

		Map<String, Object> data = this.getDataFromResponse(this.sendRequest(
				Endpoints.MESSAGE_DELIVERY_STATUS,
				this.messageUidRequestString(messageUid)));

		List<Map<String, ?>> statuses = (List<Map<String, ?>>) data
				.get("delivery_status");
		List<MessageDeliveryStatus> result = new ArrayList<MessageDeliveryStatus>();
		for (Map<String, ?> status : statuses) {
			result.add(new MessageDeliveryStatus(status));
		}
		return result;
	}

	// Since these requests are so small, don't bother creating builders /
	// params for them
	private String apiKeyRequestString() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("api_key", this.apiKey);
		return new Gson().toJson(params);
	}

	private String messageUidRequestString(String messageUid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("api_key", this.apiKey);
		params.put("uid", messageUid);
		return new Gson().toJson(params);
	}

	private String sendRequest(String endpoint, String content)
			throws PostageAppException {
		URIBuilder uriBuilder = new URIBuilder().setScheme("https")
				.setHost(API_HOST)
				.setPath("/" + this.apiVersion + "/" + endpoint + ".json");

		try {
			return this.httpClient.post(new HttpPost(uriBuilder.build()
					.toString()), content);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Map<String, Object> getDataFromResponse(String responseString)
			throws PostageAppException {
		Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> responseMap = this.gson.fromJson(responseString,
				mapType);
		Map<String, Object> response = (Map<String, Object>) responseMap
				.get("response");

		this.checkForError(response);

		return (Map<String, Object>) responseMap.get("data");
	}

	private void checkForError(Map<String, ?> responseJson)
			throws PostageAppException {
		String responseStatus = (String) responseJson.get("status");

		if (!responseStatus.equalsIgnoreCase("ok")) {
			PostageAppException exception = new PostageAppException(
					(String) responseJson.get("message"));
			exception.setMessageUid((String) responseJson.get("uid"));
			exception.setStatus((String) responseJson.get("status"));
			throw exception;
		}
	}

	private void checkAPIKey() throws PostageAppException {
		if (this.apiKey == null) {
			throw new PostageAppException(
					"No API key set! Please set your API key before using the API.");
		}
	}
}
