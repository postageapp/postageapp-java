package postageapp.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-26
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageTransmissonsResponse {
    private double messageId;
    private Map<String, MessageTransmission> transmissions = new HashMap<String, MessageTransmission>();

    public MessageTransmissonsResponse(Map<String, ?> json) {
        Map<String, Double> messageMap = (Map<String, Double>) json.get("message");
        this.messageId = messageMap.get("id");

        Map<String, ?> transmissionsMap = (Map<String, ?>) json.get("transmissions");

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
}
