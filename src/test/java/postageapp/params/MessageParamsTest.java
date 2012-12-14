package postageapp.params;

import junit.framework.TestCase;
import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.ArrayList;
import java.util.List;

public class MessageParamsTest extends ModelTestCase {
    @Test
    public void testBuildMessageParams() {
        List<String> recipients = new ArrayList<String>();
        recipients.add("recipient1@email.com");
        recipients.add("recipient2@email.com");

        MessageParams params = new MessageParams()
                .setRecipients(recipients)
                .addContentType("text/plain", "plain text")
                .addContentType("text/html", "<h1>Html!</h1")
                .addHeader("subject", "This is my subject!")
                .addHeader("from", "fake@email.com")
                .setTemplate("fake_template")
                .setVariable("Blah", "blah")
                .setMessageRecipientOverride("overriden@email.com")
                .addAttachment("filename.png", "application/octet-stream", "BASE64_ENCODED_CONTENT");

        // Simple test to verify we are generating some correct json
        String actual = this.loadModelFixture("request_fixtures/actual_send_message.json");
        assertEquals(actual, params.toString());
    }
}
