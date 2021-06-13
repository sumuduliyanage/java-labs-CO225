package bmicalculator;

import java.math.*; 
import java.io.*; // for file IO
import java.util.*;

public class Class {

	private String name;
	private double weight;
	private double height;
	
	
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
	
	//method to calculate the bmi value
	public double calBMI()
	{
		return weight/(height*height);
	}
	
	//printing the information
	public void printInfo(double bmi, String name, double height, double weight ) {
		String status = "";
		
		if (bmi>25) 
		{
			status = "You are overweight";
		}
		else if(bmi>18.5) 
		{
			status = "You are healthy";
		}
		else {
			status = "Not healthy";
		}
		
		 String bmi1 = String.format("%.6f", bmi);
		System.out.println("Name: "+name+", Height(m): "+height+", Weight(Kg): "+weight+", BMI: "+bmi1+", Status: "+status);
		
		
	}

	

}
