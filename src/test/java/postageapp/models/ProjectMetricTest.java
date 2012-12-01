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
public class ProjectMetricTest extends ModelTestCase {
    @Test
    public void testProjectMetricJson() {
        Map<String, ?> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_metrics.json"));

        Map<String, ?> metrics = (Map<String, ?>) dataObj.get("metrics");
        Map<String, ?> hour = (Map<String, ?>) metrics.get("hour");
        ProjectMetrics metricsForHour = new ProjectMetrics((Map<String, ?>) hour.get("delivered"));

        assertNotNull(metricsForHour.getCurrentPercent());
        assertNotNull(metricsForHour.getCurrentValue());
        assertNotNull(metricsForHour.getDiffPercent());
        assertNotNull(metricsForHour.getPreviousPercent());
        assertNotNull(metricsForHour.getPreviousValue());
    }
}
