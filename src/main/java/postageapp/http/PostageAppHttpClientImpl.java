package postageapp.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-26
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostageAppHttpClientImpl implements PostageAppHttpClient {
    private final HttpClient httpClient;

    public PostageAppHttpClientImpl(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public String post(String url, String postData) throws PostageAppException {
        HttpPost postRequest = new HttpPost(url);
        postRequest.addHeader(new BasicHeader("Content-Type", "application/json"));

        HttpResponse postResponse = null;
        try {
            postRequest.setEntity(new StringEntity(postData));
            postResponse = this.httpClient.execute(postRequest);
        } catch (Exception e) {
            throw new PostageAppException(e.getMessage());
        }

        if (postResponse.getStatusLine().getStatusCode() / 100 != 2) {
            throw new PostageAppException("Unable to connect to PostageApp servers.");
        }

        try {
            return IOUtils.toString(postResponse.getEntity().getContent());
        } catch (Exception e) {
            throw new PostageAppException(e.getMessage());
        }
    }
}
