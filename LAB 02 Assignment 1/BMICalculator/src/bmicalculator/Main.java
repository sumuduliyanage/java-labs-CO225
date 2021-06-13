package bmicalculator;

import java.math.*; 
import java.io.*; // for file IO
import java.util.*;



public class Main {
	public static void main(String args[])
	{
		//making an object of classnew
		Class person = new Class();
		
		
		BufferedReader descriptor = null; 
		String data = null; //string of each line is stored to data
	
		try { 
	    	descriptor = new BufferedReader(new FileReader("src\\input.txt"));
	    	
	    	

	    	while ((data = descriptor.readLine()) != null) {
	    		//datalist includes name weight and height
	    		List<String> datalist = Arrays.asList(data.split(","));
	    		
	    		//name is taken from the inputs
	    		person.setName(datalist.get(0));
	    		String name = datalist.get(0);
	    		
	    		//height is taken from the inputs
	    		double height = Double.parseDouble(datalist.get(1));
	    		person.setHeight(height);
	    		
	    		//weight is taken from the inputs
	    		double weight = Double.parseDouble(datalist.get(2));
	    		person.setWeight(weight);
	    		
	    		double bmi = person.calBMI();
	    		
	    		
	    		person.printInfo(bmi, name, height, weight);
	    		
	    	}
			
	    	descriptor.close(); 
		} catch(IOException e) { 
	    	// IOException is more generic (FileNotFound is a type of a 
	    	// IOException, so catching only that is sufficient 
	    	System.out.println("Bad things happen, what do you do!" + e);
	    	return; 
		}
	}

}
