package postageapp.models;

import java.util.HashMap;
import java.util.Map;

public class ProjectInfo extends PostageModel {
    private String name, url;
    private Map<String, String> transmissions;
    private Map<String, String> users;
    
    @SuppressWarnings("unchecked")
    public ProjectInfo(Map<String, ?> json) {
        super();

        this.name = (String) json.get("name");
        this.url = (String) json.get("url");
        this.transmissions = (Map<String, String>) json.get("transmissions");
        this.users = (Map<String, String>) json.get("users");
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getTransmissions() {
        return transmissions;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getUsers() {
        return users;
    }
    
    @Override
    public String toString() {
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("name", this.name);
        mappedParams.put("url", this.url);
        mappedParams.put("tranmissions", this.transmissions);
        mappedParams.put("users", this.users);
        return this.gson.toJson(mappedParams, this.mapType);
    }
}
