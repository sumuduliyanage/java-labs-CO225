import java.io.*;
import java.util.*; /* hash map */

public class Quit extends GenericCommand { 

    /* Quit command 
     * Only quit should be there. 
     * no arguments, 
     */ 
    
    public void handleCommand(String [] args) { 
		
		//quit command is the last command executed
	    commandsno++;
	    
		if(!args[0].equals("quit")) someThingWrong(); 

		if(args.length != 1) { 
			System.out.println("Usage: quit");
			return;
		}

		/***
		 * ###### You need to print the number of commands 
		 * that was executed before exiting
		 */
		 
	 
		//total no of commands executed are printed
	    System.out.printf("Executed %d commands since starting \n",commandsno);

	    /* OK, so just die */ 
	    System.exit(0); 
    }

}
