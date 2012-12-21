package postageapp.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageTransmission extends PostageModel {
    private String status, resultCode, errorMessage;
    private Date createdAt, failedAt, openedAt;

    public MessageTransmission(Map<String, ?> json) {
        super();

        this.status = (String) json.get("status");
        this.createdAt = this.dateFromIncorrectString((String) json.get("created_at"));
        this.failedAt = this.dateFromIncorrectString((String) json.get("failed_at"));
        this.openedAt = this.dateFromIncorrectString((String) json.get("opened_at"));
        this.resultCode = (String) json.get("result_code");
        this.errorMessage = (String) json.get("error_message");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getFailedAt() {
        return failedAt;
    }

    public Date getOpenedAt() {
        return openedAt;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("status", this.status);
        mappedParams.put("createdAt", this.createdAt);
        mappedParams.put("failedAt", this.failedAt);
        mappedParams.put("openedAt", this.openedAt);
        mappedParams.put("resultCode", this.resultCode);
        mappedParams.put("errorMessage", this.errorMessage);
        return this.gson.toJson(mappedParams, this.mapType);
    }
}
