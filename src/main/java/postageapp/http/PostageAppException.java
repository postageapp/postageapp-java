package postageapp.http;

public class PostageAppException extends Exception {
    private String status, messageUid;

    public PostageAppException(final String message) {
        super(message);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessageUid(String uid) {
        this.messageUid = uid;
    }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder();
        strBuffer.append("Error -- ");

        if (this.status != null) {
            strBuffer.append("Status: ").append(this.status).append(" ");
        }

        if (this.messageUid != null) {
            strBuffer.append("Message Uid: ").append(this.messageUid).append(" ");
        }

        if (this.messageUid != null) {
            strBuffer.append("Message: ").append(this.getMessage());
        }

        return strBuffer.toString();
    }
}
