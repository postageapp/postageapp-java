package postageapp.models;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-26
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageTransmissonsResponse {
    private String messageId;
    private Map<String, MessageTransmission> transmissions;

    public MessageTransmissonsResponse(Map<String, ?> json) {
        Map<String, String> messageMap = (Map<String, String>) json.get("message");
        this.messageId = messageMap.get("id");

        Map<String, ?> transmissionsMap = (Map<String, ?>) json.get("transmissions");

        for (String email : transmissionsMap.keySet()) {
            this.transmissions.put(email, new MessageTransmission((Map<String, String>) transmissionsMap.get(email)));
        }
    }
}
