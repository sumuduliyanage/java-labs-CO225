/*
Author : Lakmali B.L.S
Reg no : E/16/200
Lab    :06

Main class in implemented....Where the main method is
*/

public class Main {
	 public static void main(String[] args) {
	      Model model = new Model();//new model object is created
	      View view = new View();//new view object is created
	      new Controller(view,model);//Controller class is called here
	 }
}
