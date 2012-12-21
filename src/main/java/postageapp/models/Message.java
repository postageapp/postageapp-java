package postageapp.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Message extends PostageModel {
    private String uid, template;
    private double transmissionsTotal, transmissionsFailed, transmissionsCompleted;
    private Date createdAt, willPurgeAt;

    public Message(String uid, Map<String, ?> json) {
        super();

        this.uid = uid;
        this.template = (String) json.get("template");
        this.transmissionsTotal = (Double) json.get("transmissions_total");
        this.transmissionsCompleted = (Double) json.get("transmissions_completed");
        this.transmissionsFailed = (Double) json.get("transmissions_failed");
        this.createdAt = this.dateFromString((String) json.get("created_at"));
        this.willPurgeAt = this.dateFromString((String) json.get("will_purge_at"));
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getTemplate() {
        return template;
    }

    public double getTransmissionsCompleted() {
        return transmissionsCompleted;
    }

    public double getTransmissionsFailed() {
        return transmissionsFailed;
    }

    public double getTransmissionsTotal() {
        return transmissionsTotal;
    }

    public String getUid() {
        return uid;
    }

    public Date getWillPurgeAt() {
        return willPurgeAt;
    }
    
    @Override
    public String toString() {
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("uid", this.uid);
        mappedParams.put("createdAt", this.createdAt);
        mappedParams.put("template", this.template);
        mappedParams.put("transmissionsCompleted", this.transmissionsCompleted);
        mappedParams.put("transmissionsFailed", this.transmissionsFailed);
        mappedParams.put("transmissionsTotal", this.transmissionsTotal);
        mappedParams.put("willPurgeAt", this.willPurgeAt);
        return this.gson.toJson(mappedParams, this.mapType);
    }
}
