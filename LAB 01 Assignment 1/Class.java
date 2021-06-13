import java.math.*; 
import java.io.*; // for file IO
import java.util.*;



public class Class
{


	String name;
	int attendence;
	//Creating the constructor with name and attendence
	Class(String name,int attendence){
		this.name = name;
		this.attendence = attendence;
	}


	//Calculating the attendence percentage
	public double attendencePercentage(int n)
	{
		//percentage is calculated using 45 as total number of days 
		
		double percentage = (((double)n)/45)*100;
		return percentage;
	}


	//Calculating the average percentage of the class attendence
	public double averageAttendence(Class[] student)
	{
		//Sum is the total number of attendence
		double sum = 0;
		for (int i = 0;i<student.length;i++){
			sum = sum+student[i].attendence;
		}

		return (((sum/(student.length))/45)*100);
	}


	
}