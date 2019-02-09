package dmit2015.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.math3.util.Precision;

@Entity
public class BodyMassIndex {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;					// +getter +setter
	private String name;				// +getter +setter
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
