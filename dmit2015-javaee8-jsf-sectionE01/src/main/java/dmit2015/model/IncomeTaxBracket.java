package dmit2015.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties({"Region Abbreviation","BracketNo"})
public @Data class IncomeTaxBracket {
	
	@JsonProperty("Region Name")
	private String regionName = "Canada";
	
	@JsonProperty("Tax Year")
	private int taxYear;
	
	@JsonProperty("Starting Income")
	private double startingIncome;
	
	@JsonProperty("Ending Income")
	private double endingIncome;
	
	@JsonProperty("Tax Rate")
	private double taxRate;
	
	@JsonProperty("Base Tax Amount")
	private double baseTaxAmount;

}
