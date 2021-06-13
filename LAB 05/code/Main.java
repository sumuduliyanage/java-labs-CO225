/*
Author : E/16/200
Name   : Lakmali B. L. S
Lab    : 05
Implemeting Matrix Multiplication using Threads
*/

class Main { //the matrices we want to calculate
    public static int [][] a = {{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}};
    
    public static int [][] b = {{1 },
				{1 },
				{1 }};


    public static void print_matrix(int [][] a) {
		for(int i=0; i < a.length; i++) {
		    for(int j=0; j< a[i].length; j++) 
			System.out.print(a[i][j] + " "); 
		    System.out.println();
		}
    }
    

    public static void main(String [] args) { 

		int [][] x = Matrix.multiply(a, b); 

		print_matrix(x); // see if the multipication is correct 	

    }
}