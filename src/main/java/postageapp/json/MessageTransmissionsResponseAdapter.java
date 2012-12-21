package postageapp.json;

import java.io.IOException;
import java.util.Map;

import postageapp.models.MessageTransmission;
import postageapp.models.MessageTransmissionsResponse;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class MessageTransmissionsResponseAdapter extends TypeAdapter<MessageTransmissionsResponse> {
	private final MessageTransmissionAdapter messageAdapter = new MessageTransmissionAdapter();

	@Override
	public MessageTransmissionsResponse read(JsonReader reader) throws IOException {
		return null;
	}

	@Override
	public void write(JsonWriter writer, MessageTransmissionsResponse response)
			throws IOException {
		
		writer.beginObject();
		writer.name("messageId").value(response.getMessageId());
		
		Map<String, MessageTransmission> transmissions = response.getTransmissions();
		
		writer.name("transmissions").beginObject();
		
		for (String key : transmissions.keySet()) {
			writer.name(key);
			messageAdapter.write(writer, transmissions.get(key));
		}
		
		writer.endObject();
		writer.endObject();
	}
}
