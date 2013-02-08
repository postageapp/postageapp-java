package postageapp.http;

import static org.junit.Assert.*;

import java.net.URI;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PostageAppHttpClientTest {
	private HttpClient mockClient;
	private HttpPost mockRequest;
	private HttpResponse mockResponse;
	
	@Before
	public void setUp() throws Exception {
		mockClient = mock(HttpClient.class);
		
		mockRequest = new HttpPost(new URI(""));
		mockResponse = new BasicHttpResponse(new BasicStatusLine(
    		  new ProtocolVersion("HTTP", 1, 1), 200, ""));
		mockResponse.setStatusCode(200);
		mockResponse.setEntity(new StringEntity("Great Success!"));
		
		when(mockClient.execute((HttpUriRequest) anyObject())).thenReturn(mockResponse);
	}
	
	@Test
	public void testPostageUserAgent() throws Exception {
		PostageAppHttpClient client = new PostageAppHttpClientImpl(mockClient);
		client.post(mockRequest, "");
		verify(mockClient).execute(mockRequest);

		String expected = "User-Agent: POSTAGEAPP-JAVA (JAVA " + System.getProperty("java.version") + ")";
		assertEquals(expected, mockRequest.getFirstHeader(HttpHeaders.USER_AGENT).toString());
	}
}
