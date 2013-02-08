package postageapp.http;

import org.apache.http.client.methods.HttpPost;

public interface PostageAppHttpClient {
    public String post(HttpPost request, String postData) throws PostageAppException;
}
