package postageapp;

public class PostageAppFactory {
    private static final PostageAppClient singletonClient = new PostageAppClientImpl();

    public static PostageAppClient getSingleton() {
        return singletonClient;
    }
}
