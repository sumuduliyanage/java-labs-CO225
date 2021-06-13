/*******************************************************************
                 Skeleton code 
********************************************************************/
import java.io.*;
import java.util.*; /* hash map */

public class GenericCommand { 
    /* this is the generic command 
     * your commands should reimplement this
     */
	static int commandsno = 0;//no of commands executed
	
    public void handleCommand(String [] args) { 
	System.out.println("Command not implemented!");
    }

    public void someThingWrong() { 
	System.out.println("Something Wrong in code!!!");
	System.exit(-1);
    }
}

