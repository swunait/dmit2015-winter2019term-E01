package dmit2015.model;

import org.apache.commons.math3.util.Precision;

public class BodyMassIndex {
	
	private double weight = 60;			// +getter +setter
	private double height = 48;			// +getter +setter
	
	public double bmiValue() {
		double value = 0;
		value = 703 * weight / Math.pow(height, 2);
		value = Precision.round(value, 1);
		return value;
	}
	
	public String bmiClassification() {
		String value = "Unknown Classification";
		double bmi = bmiValue();
		if (bmi < 18.5) {
			value = "underweight";
		} else if (bmi < 25) {
			value = "normal";
		} else if (bmi < 30) {
			value = "overweight";
		} else {
			value = "obese";
		}
		return value;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public BodyMassIndex() {
		super();
	}

	public BodyMassIndex(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
	}
	
}
