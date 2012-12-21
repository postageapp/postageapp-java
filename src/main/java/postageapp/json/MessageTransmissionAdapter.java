package postageapp.json;

import java.io.IOException;
import java.util.Date;

import postageapp.models.MessageTransmission;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class MessageTransmissionAdapter extends
		TypeAdapter<MessageTransmission> {
	@Override
	public MessageTransmission read(JsonReader reader) throws IOException {
		return null;
	}

	private void writeDate(JsonWriter writer, String key, Date date)
			throws IOException {
		writer.name("createdAt");
		if (date != null) {
			writer.value(date.toString());
		} else {
			writer.nullValue();
		}
	}

	@Override
	public void write(JsonWriter writer, MessageTransmission msg)
			throws IOException {
		writer.beginObject();
		writer.name("status").value(msg.getStatus());

		writeDate(writer, "failedAt", msg.getFailedAt());
		writeDate(writer, "openedAt", msg.getOpenedAt());

		writer.name("resultCode").value(msg.getResultCode());
		
		writer.name("errorMessage");
		if (msg.getErrorMessage() != null) {
			writer.value(msg.getErrorMessage());
		} else {
			writer.nullValue();
		}
		
		writer.endObject();
	}
}