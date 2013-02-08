package postageapp.models;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import postageapp.ModelTestCase;

public class MessageDeliveryStatusTest extends ModelTestCase {
    @Test
    @SuppressWarnings("unchecked")
    public void testParseMessageDeliveryStatus() throws Exception {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_message_delivery_status.json"));
		List<Map<String, ?>> statuses = (List<Map<String, ?>>)dataObj.get("delivery_status");
        MessageDeliveryStatus status = new MessageDeliveryStatus(statuses.get(0));
        assertNotNull(status.getRecipient());
        assertNotNull(status.getStatus());
        assertNotNull(status.getUniqueId());
    }
}
