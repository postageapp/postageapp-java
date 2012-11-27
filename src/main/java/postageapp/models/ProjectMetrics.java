package postageapp.models;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stephanleroux
 * Date: 2012-11-23
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectMetrics extends PostageModel {
    private int currentPercent, previousPercent,
            diffPercent, currentValue, previousValue;

    public ProjectMetrics(Map<String, ?> json) {
        super(json);

        this.currentPercent = (Integer) json.get("currentPercent");
        this.previousPercent = (Integer) json.get("previousPercent");
        this.diffPercent = (Integer) json.get("diffPercent");
        this.currentValue = (Integer) json.get("currentValue");
        this.previousPercent = (Integer) json.get("previousPercent");
        this.previousValue = (Integer) json.get("previousValue");
    }

    public int getCurrentPercent() {
        return currentPercent;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getDiffPercent() {
        return diffPercent;
    }

    public int getPreviousPercent() {
        return previousPercent;
    }

    public int getPreviousValue() {
        return previousValue;
    }
}
