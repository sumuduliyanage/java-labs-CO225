/*
Author : Lakmali B.L.S
Reg no : E/16/200
Lab    :06

Model Class of MVC structure is implemented here. 
*/


public class Model {

    
	private static int[][] array = {{0,0,0},{0,0,0},{0,0,0}};//initialize the array
	
	
	
	//method to update the array
	public  void array_update(int rem,int i,int j) {
		if (rem==0) {
			 array[i][j] = 2;//array is updated
		 }
		 else {
			 array[i][j] = 1;
		 }
	}
	
	//returning the array
	public int[][] get_array(){
		return array;
	}
	
	//calculating the remainder of a number
	public int get_remainder(int val) {
		return (val%2);
	}
	
	//this method calculates whether there is a winner
	public int get_winner () {
		int winner = -1;//if there is no winner
		
		//checking for the winner
		if ((array[0][0] == 1)&&(array[0][1] == 1)&&(array[0][2] == 1)) //checking three ones in row 1
		{
			winner = 1;
		}
		else if ((array[1][0] == 1)&&(array[1][1] == 1)&&(array[1][2] == 1)) {//checking three ones in row 2
			winner = 1;
		}
		else if ((array[2][0] == 1)&&(array[2][1] == 1)&&(array[2][2] == 1)){//checking three ones in row 3
			winner  = 1;
		}
		else if ((array[0][0] == 1)&&(array[1][1] == 1)&&(array[2][2] == 1)) {//checking three ones in main digonal
			winner = 1;
		}
		else if ((array[2][0] == 1)&&(array[1][1] == 1)&&(array[0][2] == 1)) {//checking three ones in other digonal
			winner = 1;
		}
		else if ((array[0][0] == 1)&&(array[1][0] == 1)&&(array[2][0] == 1)) {//checking three ones in col 1
			winner = 1;
		}
		else if ((array[0][1] == 1)&&(array[1][1] == 1)&&(array[2][1] == 1)) {//checking three ones in col 2
			winner = 1;
		}
		else if ((array[0][2] == 1)&&(array[1][2] == 1)&&(array[2][2] == 1)) {//checking three ones in col 3
			winner = 1;
		}
		else if ((array[0][0] == 2)&&(array[0][1] == 2)&&(array[0][2] == 2)) //checking three 2s in row 1
		{
			winner = 2;
		}
		else if ((array[1][0] == 2)&&(array[1][1] == 2)&&(array[1][2] == 2)) {//checking three 2s in row 2
			winner = 2;
		}
		else if ((array[2][0] == 2)&&(array[2][1] == 2)&&(array[2][2] == 2)){//checking three 2s in row 3
			winner = 2;
		}
		else if ((array[0][0] == 2)&&(array[1][1] == 2)&&(array[2][2] == 2)) {//checking three ones in main digonal
			winner = 2;
		}
		else if ((array[2][0] == 2)&&(array[1][1] == 2)&&(array[0][2] == 2)) {//checking three ones in other digonal
			winner = 2;
		}
		else if ((array[0][0] == 2)&&(array[1][0] == 2)&&(array[2][0] == 2)) {//checking three 2s in col 1
			winner = 2;
		}
		else if ((array[0][1] == 2)&&(array[1][1] == 2)&&(array[2][1] == 2)) {//checking three 2s in col 2
			winner = 2;
		}
		else if ((array[0][2] == 2)&&(array[1][2] == 2)&&(array[2][2] == 2)) {//checking three 2s in col 3
			winner = 2;
		}
		
		else {//checking for draw
			int draw = 1;
			for (int i=0;i<3;i++) {
				for (int j=0;j<3;j++) {
					if (array[i][j]==0) {
						draw = 0;
						i=3;
						break;
					}
				}
			}
			
			if (draw == 1) {
				winner = 0;
			}
		}
		
		return winner;//no winner -> -1, winner 1 -> 1, winner 2->2, draw->0
	}

	public void array_reset() {//reseting the array after the game 
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				array[i][j] = 0;
			}
		}
	}
}