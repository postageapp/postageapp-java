package postageapp.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostageAppExceptionTest {
    private static final String errorString1 = "Error -- Status: fail Message Uid: 1928383702992 Message: Something went terribly wrong...";
    private static final String errorString2 = "Error -- Message Uid: 1928383702992 Message: Something went terribly wrong...";
    private static final String errorString3 = "Error -- Status: fail ";

    @Test
    public void testExceptionFormatsFullError() {
        PostageAppException exception1 = new PostageAppException("Something went terribly wrong...");
        exception1.setMessageUid("1928383702992");
        exception1.setStatus("fail");

        assertEquals(exception1.toString(), errorString1);
    }

    @Test
    public void testExceptionFormatsNoStatus() {
        PostageAppException exception1 = new PostageAppException("Something went terribly wrong...");
        exception1.setMessageUid("1928383702992");

        assertEquals(exception1.toString(), errorString2);
    }

    @Test
    public void testExceptionFormatsNoMessage() {
        PostageAppException exception1 = new PostageAppException("Something went terribly wrong...");
        exception1.setStatus("fail");

        assertEquals(exception1.toString(), errorString3);
    }
}
