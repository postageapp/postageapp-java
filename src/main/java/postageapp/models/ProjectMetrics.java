package postageapp.models;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV;

import java.util.Map;

public class ProjectMetrics extends PostageModel {
    private double currentPercent, previousPercent,
            diffPercent, currentValue, previousValue;

    public ProjectMetrics(Map<String, ?> json) {
        super(json);

        this.currentPercent = (Double) json.get("current_percent");
        this.previousPercent = (Double) json.get("previous_percent");
        this.diffPercent = (Double) json.get("diff_percent");
        this.currentValue = (Double) json.get("current_value");
        this.previousPercent = (Double) json.get("previous_percent");
        this.previousValue = (Double) json.get("previous_value");
    }

    public double getCurrentPercent() {
        return currentPercent;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public double getDiffPercent() {
        return diffPercent;
    }

    public double getPreviousPercent() {
        return previousPercent;
    }

    public double getPreviousValue() {
        return previousValue;
    }
}
