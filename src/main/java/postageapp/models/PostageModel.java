package postageapp.models;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import postageapp.json.MessageTransmissionAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

public abstract class PostageModel {
    protected Gson gson = new Gson();
	protected final Type mapType = new TypeToken<Map<String, Object>>() {}.getType();

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    private DateTimeFormatter incorrectFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    
    public PostageModel() {
    	 GsonBuilder gsonBuilder = new GsonBuilder();
    	 gsonBuilder.registerTypeAdapter(MessageTransmission.class, new MessageTransmissionAdapter().nullSafe());
    	 this.gson = gsonBuilder.create();
    }

    protected Date dateFromIncorrectString(String date) {
    	// Thanks Scott
    	if (date != null) {
             return this.incorrectFormatter.parseDateTime(date).toDate();
         }

    	 return null;
    }
    
    protected Date dateFromString(String date) {
        if (date != null) {
            return this.formatter.parseDateTime(date).toDate();
        }

        return null;
    }
}
