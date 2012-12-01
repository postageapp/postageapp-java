package postageapp.models;

import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-29
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectInfoTest extends ModelTestCase {
    @Test
    public void testParseProjectIntoJson() {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_project_info.json"));

        ProjectInfo info = new ProjectInfo((Map<String, ?>)dataObj.get("project"));

        assertNotNull(info);
        assertNotNull(info.getName());
        assertNotNull(info.getTransmissions());
        assertNotNull(info.getTransmissions().get("today"));
        assertNotNull(info.getTransmissions().get("overall"));
        assertNotNull(info.getTransmissions().get("this_month"));
        assertNotNull(info.getUrl());
        assertNotNull(info.getUsers());
        assertNotNull(info.getUsers().get("tester@test.com"));
    }
}
