package postageapp.models;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MessageTransmission extends PostageModel {
    private String status, resultCode, errorMessage;
    private Date createdAt, failedAt, openedAt;

    public MessageTransmission(Map<String, ?> json) {
        super(json);

        this.status = (String) json.get("status");
        this.createdAt = this.dateFromString((String) json.get("created_at"));
        this.failedAt = this.dateFromString((String) json.get("failed_at"));
        this.openedAt = this.dateFromString((String) json.get("opened_at"));
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
}
