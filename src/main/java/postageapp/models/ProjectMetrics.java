package postageapp.models;

import java.util.HashMap;
import java.util.Map;

public class ProjectMetrics extends PostageModel {
    private double currentPercent, previousPercent,
            diffPercent, currentValue, previousValue;

    public ProjectMetrics(Map<String, ?> json) {
        super();

        this.currentPercent = (Double) json.get("current_percent");
        this.previousPercent = (Double) json.get("previous_percent");
        this.diffPercent = (Double) json.get("diff_percent");
        this.currentValue = (Double) json.get("current_value");
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
    
    @Override
    public String toString() {
        Map<String, Object> mappedParams = new HashMap<String, Object>();
        mappedParams.put("currentPercent", this.currentPercent);
        mappedParams.put("previousPercent", this.previousPercent);
        mappedParams.put("diffPercent", this.diffPercent);
        mappedParams.put("currentValue", this.currentValue);
        mappedParams.put("previousValue", this.previousValue);
        return this.gson.toJson(mappedParams, this.mapType);
    }
}
