package org.jasrodis.example.model;

import java.io.Serializable;
import java.util.Random;

public class ModelInfo implements Serializable {

	private static final long serialVersionUID = -7984032536291170146L;

	private double valueA;
	private double valueB;

	public double getValueA() {
		return valueA;
	}

	public double getValueB() {
		return valueB;
	}

	public void changeValues() {
		this.valueA = random(-10, 10);
        this.valueB = random(-10, 10);
	}
	
	public static int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max) + min;
	}
	
}
