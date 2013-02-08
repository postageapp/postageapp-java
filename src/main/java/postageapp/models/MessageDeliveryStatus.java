package postageapp.models;

import java.util.HashMap;
import java.util.Map;

public class MessageDeliveryStatus extends PostageModel {
	private String uniqueId, recipient, status;
	
	public MessageDeliveryStatus(Map<String, ?> json) {
		super();

		this.uniqueId = (String) json.get("unique_id");
		this.recipient = (String) json.get("recipient");
		this.status = (String) json.get("status");
	}
	
	public String getUniqueId() {
		return uniqueId;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getStatus() {
		return status;
	}
	
	@Override
    public String toString() {
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("status", this.status);
        mappedParams.put("uniqueId", this.uniqueId);
        mappedParams.put("recipient", this.recipient);
        return this.gson.toJson(mappedParams, this.mapType);
    }
}
