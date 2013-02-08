package postageapp.models;

import java.util.Map;

public class RecipientInfo extends PostageModel {
	private String status, message;
	private Double score, openedCount, clickedCount, softBounceCount,
			hardBounceCount, optOutCount, spamReportCount;

	public RecipientInfo(Map<String, ?> json) {
		super();
		
		this.status = (String)json.get("status");
		this.message = (String)json.get("message");
		
		this.score = (Double)json.get("score");
		this.openedCount = (Double)json.get("opened_count");
		this.clickedCount = (Double)json.get("clicked_count");
		this.softBounceCount = (Double)json.get("soft_bounce_count");
		this.hardBounceCount = (Double)json.get("hard_bounce_count");
		this.optOutCount = (Double)json.get("opt_out_count");
		this.spamReportCount = (Double)json.get("spam_report_count");
	}
	
	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Double getScore() {
		return score;
	}

	public Double getOpenedCount() {
		return openedCount;
	}

	public Double getClickedCount() {
		return clickedCount;
	}

	public Double getSoftBounceCount() {
		return softBounceCount;
	}

	public Double getHardBounceCount() {
		return hardBounceCount;
	}

	public Double getOptOutCount() {
		return optOutCount;
	}

	public Double getSpamReportCount() {
		return spamReportCount;
	}
}
