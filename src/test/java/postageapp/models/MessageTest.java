package postageapp.models;

import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.Map;

public class MessageTest extends ModelTestCase {
    @Test
    @SuppressWarnings("unchecked")
    public void testParseMessageJson() throws Exception {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_get_messages.json"));
        Message msg = new Message("27cf6ede7501a32d54d22abe17e3c154d2cae7f3",
                (Map<String, Object>)dataObj.get("27cf6ede7501a32d54d22abe17e3c154d2cae7f3"));
        assertNotNull(msg.getCreatedAt());
        assertNotNull(msg.getTemplate());
        assertNotNull(msg.getTransmissionsCompleted());
        assertNotNull(msg.getTransmissionsFailed());
        assertNotNull(msg.getTransmissionsTotal());
        assertNotNull(msg.getUid());
        assertNotNull(msg.getWillPurgeAt());
    }
}
