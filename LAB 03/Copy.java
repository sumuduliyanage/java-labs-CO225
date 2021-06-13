import java.io.*;
import java.util.*; /* hash map */

public class Copy extends GenericCommand { 
	/* we copy a file from one file to another destination*/
	/* we take two input arguments. source file name and destination file name*/
	
	
	public void handleCommand(String [] args) { 
		commandsno++; //if copy command is executed 
		
		if(!args[0].equals("copy")) someThingWrong(); 
		
		//if the user gives more than three inputs, we have to return from the execution
		if(args.length != 3) { 
			System.out.println("Usage: copy sourcefilename.extension destinationfile.extension");
			 return;
		}
		
		String srcfile = args[1];//arg[1] contains name of source file
		String desfile = args[2];//arg[2] contains name of destination file
		
		//Reading the file
		BufferedReader descriptor = null; 
		
		String line = null; 
				
				
		try { 
			 BufferedWriter writer = new BufferedWriter(new FileWriter(desfile));
			 descriptor = new BufferedReader(new FileReader(srcfile));
			    	
			 //the source file is read until the end	
			 while ((line = descriptor.readLine()) != null) {
			    	 writer.write(line); 	//line of the source file is written
			    	 writer.newLine();		//cursor is moved to new line
			  }	
			  
			  descriptor.close(); 
			  writer.close();
			  
			  System.out.println("Copied");
	   }
	   catch(IOException e) 
	   { 
			  // IOException is more generic (FileNotFound is a type of a 
			  // IOException, so catching only that is sufficient 
			  System.out.println("There is no source file with the given name.");
	   }
	   
	   
	}
}
