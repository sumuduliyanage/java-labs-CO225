class Lab1_E16200 { 

    public static void showMaxima(int [] array) { 
    	int n = array.length;
	int count=0;

    	//local maxima values are searched
		for (int i = 1;i<(array.length-1);i++)
		{	
			//each element is checked with neighboring two elements
			if ((array[i]>=array[i-1])&&(array[i]>=array[i+1]))
			{
				System.out.println("Maxima: "+array[i]+" Index: "+i);
				count++;
			}

		}
		
		if (count==0){
				System.out.println("No Local Maximas");
		}

			
    }

    public static void main(String [] args) { 
	int [] array = {0, 1, 2, 1, 0, -1, 2, 3, 5, 6, 7, 4, 3, 4, 6, 5, 4};
	
	showMaxima(array);
    }
}
