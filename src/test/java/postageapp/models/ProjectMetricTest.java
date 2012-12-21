package postageapp.models;

import org.junit.Test;
import postageapp.ModelTestCase;

import java.util.Map;

public class ProjectMetricTest extends ModelTestCase {
    @Test
    @SuppressWarnings("unchecked")
    public void testProjectMetricJson() {
        Map<String, Object> dataObj = this.getDataFromResponse(this.loadModelFixture("mock_api_1.0/mock_metrics.json"));

        Map<String, Object> metrics = (Map<String, Object>) dataObj.get("metrics");
        Map<String, Object> hour = (Map<String, Object>) metrics.get("hour");
        ProjectMetrics metricsForHour = new ProjectMetrics((Map<String, Object>) hour.get("delivered"));

        assertNotNull(metricsForHour.getCurrentPercent());
        assertNotNull(metricsForHour.getCurrentValue());
        assertNotNull(metricsForHour.getDiffPercent());
        assertNotNull(metricsForHour.getPreviousPercent());
        assertNotNull(metricsForHour.getPreviousValue());
    }
}
