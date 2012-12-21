package postageapp.models;

import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.Map;

public class AccountInfoTest extends ModelTestCase {
    @Test
    @SuppressWarnings("unchecked")
    public void testParseAccountInfoJson() throws Exception {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_account_info.json"));

        AccountInfo info = new AccountInfo((Map<String, Object>)dataObj.get("account"));

        assertNotNull(info.getName());
        assertNotNull(info.getTransmissions());
        assertNotNull(info.getTransmissions().get("today"));
        assertNotNull(info.getTransmissions().get("this_month"));
        assertNotNull(info.getTransmissions().get("overall"));
        assertNotNull(info.getUrl());
        assertNotNull(info.getUsers());
    }
}
