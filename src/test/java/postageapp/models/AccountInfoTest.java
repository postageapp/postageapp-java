package postageapp.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import postageapp.ModelTestCase;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-28
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountInfoTest extends ModelTestCase {
    @Test
    public void testParseAccountInfoJson() throws Exception {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_account_info.json"));

        AccountInfo info = new AccountInfo((Map<String, ?>)dataObj.get("account"));

        assertNotNull(info.getName());
        assertNotNull(info.getTransmissions());
        assertNotNull(info.getTransmissions().get("today"));
        assertNotNull(info.getTransmissions().get("this_month"));
        assertNotNull(info.getTransmissions().get("overall"));
        assertNotNull(info.getUrl());
        assertNotNull(info.getUsers());
    }
}
