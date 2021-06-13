/*
Author : E/16/200
Name   : Lakmali B. L. S
Lab    : 05
Implemeting Matrix Multiplication using Threads
*/



/*
Answers to the questions

1. How to use threads to parallelize the operation? 
	Each of the element of result matrix is determined using different threads
	if matrix A is multiplied by Matrix B,

	A =  {{a1, a2, a3},
		 {b1, b2, b3},
		 {c1, c2, c3}};
    
    B = {{d1 },
		{e1 },
		{ f1}};

	So , here I'm creating 3 (3x1) threads,
	Thread 1 -: (a1xd1)+(a2xe1)+(a3xf1)------->p1
	Thread 2 -: (b1xd1)+(b2xe1)+(b3xf1)------->p2
	Thread 3 -: (c1xd1)+(c2xe1)+(c3xf1)------->p3

	result matrix C =  {{p1 },
		                {p2 },
		                { p3}};

	Each thread runs parallaly and determines the elements of result matrix.


2. How may threads to  use? 

	If the result matrix (here c) has x no of rows and y no of columns,

	The no of Threads = x * y;



3. How to allocate work for each thread (recall it is the run function which all the threads execute) 

	Each thread determines an element in the result matrix

	for(s=0,k=0; k<z01; k++) //one element of the result matrix is calculated
			s += a[i1][k] * b[k][j1];
		c[i1][j1] = s;


	Each of the element of result matrix is determined using different threads
	if matrix A is multiplied by Matrix B,

	A =  {{a1, a2, a3},
		 {b1, b2, b3},
		 {c1, c2, c3}};
    
    B = {{d1 },
		{e1 },
		{ f1}};

	result matrix C =  {{p1 },
		                {p2 },
		                { p3}};

	So , here I'm creating 3 (3x1) threads,
	Thread 1 -: (a1xd1)+(a2xe1)+(a3xf1)------->p1
	Thread 2 -: (b1xd1)+(b2xe1)+(b3xf1)------->p2
	Thread 3 -: (c1xd1)+(c2xe1)+(c3xf1)------->p3
	
	This is how I have allocated work for all the threads
	


4. How to synchronize? 
	Threads should be synchronized to avoid critical resource use conflicts.
	The threads are synchronized with the synchronized blocks. For that "sysnchronized" keyword is used.
	Here, I have implemented synchronized method mul to achive thread synchronization.


*/

import java.util.*;


public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 

    /* You might need other variables as well */
    
    int z01;//no of columns in a 
    int i1; 
    int j1;

    private static Matrix  matrix[][];//object array

    

    public Matrix(int[][] a, int[][] b,int i1,int j1,int z01) { // need to change this, might need some information 
    	
        this.a = a;
        this.b = b;

        this.i1 = i1;
        this.j1 = j1;
        this.z01 = z01;

    }

   

    //overriding run method in threads
    @Override
	public void run() {	
		matrix[i1][j1].mul();//allocate work for each thread- mul method
	}

    public static int [][] multiply(int [][] a, int [][] b) {

		/* check if multipication can be done, if not 
		 * return null 
		 * allocate required memory 
		 * return a * b
		 */

		int x = a.length; 
		int y = b[0].length; 

		int z1 = a[0].length; 
		int z2 = b.length; 

		if(z1 != z2) { 
		    System.out.println("Cannnot multiply");
		    return null;
		}

		c = new int [x][y]; 
	

		int numberOfThreads = x*y; // no of threads want = no of rows in result matrix * no of columns in result matrix


		List<Thread> threads = new ArrayList<>(numberOfThreads);//Threads are taken into a Thread array

		matrix = new Matrix[x][y];//object 2d array

		

		for (int i = 0; i< x; i++) {
			for(int j=0;j<y;j++){	
				matrix[i][j] = new Matrix (a,b,i,j,z1);	
				Thread t = new Thread(matrix[i][j]);//thread is created
			   	t.start();//start method is called
			   	threads.add(t);
			}
		}
					  
		

		for (Thread t : threads){
			try{
				t.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		   
		}

		return c; 
	}

	//mul method is synchronized
	public synchronized void mul(){
   
		int s,k;  
		//this work is allocated for a thread
		for(s=0,k=0; k<z01; k++) //one element of the result matrix is calculated
			s += a[i1][k] * b[k][j1];
		c[i1][j1] = s;
				    
	}

}