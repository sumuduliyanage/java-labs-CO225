import java.math.*; 
import java.io.*; // for file IO
import java.util.*;


public class Main
{
	public static void main (String args[])
	{
		//This is the no of names in the file we are going to read
		int n = 61;

		//Creating the object array
		Class student[] = new Class[n] ;


		//Reading the file
		BufferedReader descriptor = null; 
		String line = null; 
		int MAX = 45;
		int randomNumber = 0;
	
		try { 
	    	descriptor = new BufferedReader(new FileReader("co225-classlist.txt"));

	    	for(int i = 0; i < n; i++) {
	    		String nameOfStudent = descriptor.readLine(); 
	    		
	    		//generating a random number between 0 and 45
   				Random rand = new Random();
   				randomNumber = rand.nextInt((MAX - 0) + 1) + 0;
   				
   				//Assigning values for elements in object array
	    		student[i] = new Class(nameOfStudent,randomNumber);
	    	}
			
			
	    	descriptor.close(); 
		} catch(IOException e) { 
	    	// IOException is more generic (FileNotFound is a type of a 
	    	// IOException, so catching only that is sufficient 
	    	System.out.println("Bad things happen, what do you do!" + e);
	    	return; 
		}
		System.out.println("Students Who Have Less Than 80% Attendence");
		System.out.println();
		int noOfStudent=0;
		//Calculating the attendence percentage
		for (int i = 0;i<n;i++)
		{
			double attendencePercentage = student[i].attendencePercentage(student[i].attendence);
			if (attendencePercentage<80.0){
				noOfStudent++;
				String strDouble = String.format("%.2f",attendencePercentage );
				System.out.println(student[i].name+"   "+strDouble+"%");
			}
			
		}

		System.out.println();
		System.out.println("No Of Students Who have Less Than 80%: "+noOfStudent);


		System.out.println();
		//Showing the whole class average attendence percentage
		String st12 = String.format("%.3f", student[0].averageAttendence(student));
		System.out.println("Average Attendance Percentage Of All The Students: "+st12+"%");

	}
}