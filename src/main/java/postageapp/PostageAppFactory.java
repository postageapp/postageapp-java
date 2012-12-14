package postageapp;

public class PostageAppFactory {
    private final PostageAppClient singletonClient = new PostageAppClientImpl();

    public PostageAppClient getSingleton() {
        return singletonClient;
    }
}
