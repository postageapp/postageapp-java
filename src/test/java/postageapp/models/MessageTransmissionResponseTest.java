package postageapp.models;

import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.Map;

public class MessageTransmissionResponseTest extends ModelTestCase {
    @Test
    public void testParseMessageTransmissionResponseJson() {
        Map<String, ?> data = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_message_transmissions.json"));
        MessageTransmissonsResponse response = new MessageTransmissonsResponse(data);
        assertNotNull(response);
        assertNotNull(response.getMessageId());
        assertNotNull(response.getTransmissions());

        MessageTransmission transmission = response.getTransmissions().get("tester@test.com");
        assertNotNull(transmission);
        assertNotNull(transmission.getErrorMessage());
        assertNotNull(transmission.getCreatedAt());
        assertNull(transmission.getFailedAt());
        assertNotNull(transmission.getOpenedAt());
        assertNotNull(transmission.getResultCode());
        assertNotNull(transmission.getStatus());
    }
}
