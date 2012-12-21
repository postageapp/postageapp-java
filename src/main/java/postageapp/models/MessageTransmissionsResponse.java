package postageapp.models;

import java.util.HashMap;
import java.util.Map;

import postageapp.json.MessageTransmissionAdapter;
import postageapp.json.MessageTransmissionsResponseAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageTransmissionsResponse {
    private Gson gson;
	
    private double messageId;
    private Map<String, MessageTransmission> transmissions = new HashMap<String, MessageTransmission>();

    @SuppressWarnings("unchecked")
    public MessageTransmissionsResponse(Map<String, ?> json) {
    	// Setup gson parser
   	 	GsonBuilder gsonBuilder = new GsonBuilder();
   	 	gsonBuilder.registerTypeAdapter(MessageTransmission.class, new MessageTransmissionAdapter().nullSafe());
   	 	gsonBuilder.registerTypeAdapter(MessageTransmissionsResponse.class, new MessageTransmissionsResponseAdapter().nullSafe());
   	 	this.gson = gsonBuilder.create();
    	
        Map<String, Double> messageMap = (Map<String, Double>) json.get("message");
        this.messageId = messageMap.get("id");

        Map<String, Object> transmissionsMap = (Map<String, Object>) json.get("transmissions");

        for (String email : transmissionsMap.keySet()) {
            this.transmissions.put(email, new MessageTransmission((Map<String, String>) transmissionsMap.get(email)));
        }
    }

    public double getMessageId() {
        return this.messageId;
    }

    public Map<String, MessageTransmission> getTransmissions() {
        return this.transmissions;
    }
    
    @Override
    public String toString() {
        return this.gson.toJson(this);
    }
}
