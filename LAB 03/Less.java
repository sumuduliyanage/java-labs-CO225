import java.io.*;
import java.util.*; /* hash map */


public class Less extends GenericCommand { 
	
	public void handleCommand(String [] args) { 
		
		commandsno++;//no of commands is incremented 
		
		if(!args[0].equals("less")) someThingWrong(); 
		
		
		//if the user gives more than three inputs, we have to return from the execution
		if(args.length != 2) { 
			System.out.println("Usage: less filename.txt");
			 return;
		}
				
		String srcfile = args[1];//the name of the text file 
		
		List <String> strarr = Arrays.asList(srcfile.split("\\."));
		
		String s = strarr.get(1);
		
		if (!(s.equals("txt")))
		{
			System.out.println("The file should be a text file. It should have a .txt extension");
			return;
		}
		
		
			 
		
		//Reading the file
		BufferedReader descriptor = null; 
		String line = null; 
		
				
		try { 
			 descriptor = new BufferedReader(new FileReader(srcfile));
			    	
			   //loop is gone until end of the file 	
			 while ((line = descriptor.readLine()) != null) {
			   System.out.println(line); 	//a line is printed 
			  }	
			  descriptor.close(); 
			  
			
	   }
	   catch(IOException e) 
	   { 
			  // IOException is more generic (FileNotFound is a type of a 
			  // IOException, so catching only that is sufficient 
			  System.out.println("There is no source file with the given name.");
	   }
	   
	}
}
