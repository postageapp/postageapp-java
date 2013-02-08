package postageapp.models;

import java.util.Map;

import org.junit.Test;

import postageapp.ModelTestCase;

public class RecipientInfoTest extends ModelTestCase {
    @SuppressWarnings("unchecked")
	@Test
    public void test() throws Exception {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_recipient_info.json"));
        Map<String, ?> recipients = (Map<String, ?>) dataObj.get("recipients");
        Map<String, ?> model = (Map<String, ?>) recipients.get("test@test.com");
        
        RecipientInfo info = new RecipientInfo(model);
        assertNotNull(info.getClickedCount());
        assertNotNull(info.getHardBounceCount());
        assertNotNull(info.getMessage());
        assertNotNull(info.getOpenedCount());
        assertNotNull(info.getOptOutCount());
        assertNotNull(info.getScore());
        assertNotNull(info.getSoftBounceCount());
        assertNotNull(info.getSpamReportCount());
        assertNotNull(info.getStatus());
    }
}
