package postageapp.http;

public interface PostageAppHttpClient {
    public String post(String url, String postData) throws PostageAppException;
}
