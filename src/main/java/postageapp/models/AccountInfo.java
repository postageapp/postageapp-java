package postageapp.models;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountInfo extends PostageModel {
    private String name, url;
    private Map<String, String> transmissions;
    private Map<String, String> users;

    public AccountInfo(Map<String, ?> json) {
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
