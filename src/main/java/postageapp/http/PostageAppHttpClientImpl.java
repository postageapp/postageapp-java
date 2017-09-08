package postageapp.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

public class PostageAppHttpClientImpl implements PostageAppHttpClient {
    private final HttpClient httpClient;

    private String getUserAgent() {
    	StringBuffer buf = new StringBuffer();
    	buf.append("PostageApp-Java ");
    	buf.append("(Java ");
    	buf.append(System.getProperty("java.version"));
    	buf.append(")");
    	return buf.toString();
    }
    
    public PostageAppHttpClientImpl(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    @Override
    public String post(HttpPost request, String postData) throws PostageAppException {
        request.addHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
        request.addHeader(HttpHeaders.USER_AGENT, this.getUserAgent());
        
        HttpResponse postResponse;

        try {
        	
        	request.setEntity(new StringEntity(postData));
            postResponse = this.httpClient.execute(request);
        } catch (Exception e) {
            throw new PostageAppException(e.getMessage());
        }

        if (postResponse.getStatusLine().getStatusCode() / 100 != 2) {
            throw new PostageAppException("Unable to connect to PostageApp servers for API endpoint " + request.getURI().toString());
        }

        try {
            return IOUtils.toString(postResponse.getEntity().getContent());
        } catch (Exception e) {
            throw new PostageAppException(e.getMessage());
        }
    }
}
