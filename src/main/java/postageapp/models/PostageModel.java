package postageapp.models;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
    private Map<String, ?> json;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    public PostageModel(Map<String, ?> json) {
        this.json = json;
    }

    protected Date dateFromString(String date) {
        if (date != null) {
            return this.formatter.parseDateTime(date).toDate();
        }

        return null;
    }
}
