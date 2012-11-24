package postageapp.models;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    private String uid, template;
    private int  transmissionsTotal, transmissionsFailed, transmissionsCompleted;
    private Date createdAt, willPurgeAt;
}
