package postageapp.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-26
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PostageModel {
    private final DateFormat dateFormat = new SimpleDateFormat("YYY-MM-dd hh:mm:ss");
    private Map<String, ?> json;

    public PostageModel(Map<String, ?> json) {
        this.json = json;
    }

    protected Date dateFromString(String date) {
        try {
            return this.dateFormat.parse((String) json.get("created_at"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
