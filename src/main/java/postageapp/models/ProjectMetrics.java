package postageapp.models;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectMetrics {
    public static enum WHEN {
        HOUR, DATE, WEEK, MONTH
    }

    private int currentPercent, previousPercent,
            diffPercent, currentValue, previousValue;
}
