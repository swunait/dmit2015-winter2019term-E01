package dmit2015.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.model.BodyMassIndex;

@Named
@RequestScoped
public class BodyMassIndexController {

	private BodyMassIndex currentBMI = new BodyMassIndex();	// +getter
	
	public void calculate() {
		String message = String.format("Your Body Mass Index is %s. This is considered %s ", 
			currentBMI.bmiValue(), currentBMI.bmiClassification()	);
		if (currentBMI.bmiClassification().equalsIgnoreCase("underweight")) {
			Messages.addGlobalWarn(message);
		} else if (currentBMI.bmiClassification().equalsIgnoreCase("normal")) {
			Messages.addGlobalInfo(message);
		} else if (currentBMI.bmiClassification().equalsIgnoreCase("overweight")) {
			Messages.addGlobalError(message);
		} else {
			Messages.addGlobalFatal(message);
		}
	}

	public BodyMassIndex getCurrentBMI() {
		return currentBMI;
	}
	
}
