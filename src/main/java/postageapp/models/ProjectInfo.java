package postageapp.models;

import java.util.Map;

public class ProjectInfo extends PostageModel {
    private String name, url;
    private Map<String, String> transmissions;
    private Map<String, String> users;

    public ProjectInfo(Map<String, ?> json) {
        super(json);

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
}
