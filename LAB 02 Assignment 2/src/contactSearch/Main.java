package contactSearch;

import java.io.*; // for file IO
import java.math.*; 
import java.util.*;

public class Main {
	public static void main  (String args[])
	{
				//checking whether the input is in correct format
				String  input = args[0];
				if (input.indexOf(":") < 0) {
					System.out.println("Invalid Input Format! Input Should be  F:firstname or L:lastname");
					return;
					
				}
				

				//condition keeps data about the input . whether the user gives first name and last name
				int condition =0;
				List<String> s = Arrays.asList(input.split(":"));
				String name = s.get(1);
				
				if ("F".equals(s.get(0))) {
					condition=1;
				}
				else if ("L".equals(s.get(0))){
					condition =2;
				}
				else {
					System.out.println("Invalid Input Format! Input Should be  F:firstname or L:lastname");
					return;
				}
				
				
		
		        ArrayList<Class> person = new ArrayList<Class>();
		       

				//Reading the file
				BufferedReader descriptor = null; 
				String line = null; 
				int n=0;
				
				
				try { 
			    	descriptor = new BufferedReader(new FileReader("src\\contacts.txt"));
			    	
			    	
			    	while ((line = descriptor.readLine()) != null) {
			    		List<String> details = Arrays.asList(line.split(","));
			    		person.add(new Class(details.get(0),details.get(1),details.get(2)));
			    		n++;
			    	}


			    	
			    	descriptor.close(); 
				} catch(IOException e) { 
			    	// IOException is more generic (FileNotFound is a type of a 
			    	// IOException, so catching only that is sufficient 
			    	System.out.println("Bad things happen, what do you do!" + e);
			    	return; 
				}
				
				
				int c = 0;
				
				for (int i=0;i<n;i++)
				{
					if (condition==1) {
						if (name.equalsIgnoreCase(person.get(i).firstName)) {
							System.out.println(person.get(i).firstName+" "+person.get(i).lastName+" : "+person.get(i).contactNumber);
							c=1;
						}
					}
					
					else if (condition==2) {
						if (name.equalsIgnoreCase(person.get(i).lastName)) {
							System.out.println(person.get(i).firstName+" "+person.get(i).lastName+" : "+person.get(i).contactNumber);
							c=1;
						}
					}
					
					else {
						return;
					}
					
				
				}
				
				if (c==0) {
					System.out.println("No Contact Numbers");
				}
		
	}

}
