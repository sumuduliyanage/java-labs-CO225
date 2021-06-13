/*
Author : Lakmali B.L.S
Reg no : E/16/200
Lab    :06

This is the Controller class implementation in MVC. 
*/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class Controller implements ActionListener{
	
	private View view;
	private Model model;
	
	public static int val = 0;
	
	//constructor
	Controller (View view,Model model){
		this.view = view;
		this.model = model;
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				this.view.button[i][j].addActionListener((ActionListener) this);
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		val++; //when  a button is pressed, value is incremented by 1
		int rem=model.get_remainder(val);//remainder is taken
		
		//according to the button you have pressed 
		if(e.getSource() == view.button[0][0]) { 
			 model.array_update(rem,0,0);//array is updated
			 view.cell_update(rem,0,0);//cell view is changed
			 view.button_disable(0,0);//you can't press that button again
		}
		else if(e.getSource() == view.button[0][1]) {
			 model.array_update(rem,0,1);
			 view.cell_update(rem,0,1);
			 view.button_disable(0,1);
		}
		else if(e.getSource() == view.button[0][2]) {
			model.array_update(rem,0,2);
			view.cell_update(rem,0,2);
			view.button_disable(0,2);
		}
		else if(e.getSource() == view.button[1][0]) {
			model.array_update(rem,1,0);
			view.cell_update(rem,1,0);
			view.button_disable(1,0);			
		}
		else if(e.getSource() == view.button[1][1]) {
			 model.array_update(rem,1,1);
			 view.cell_update(rem,1,1);
			 view.button_disable(1,1);
		}
		else if(e.getSource() == view.button[1][2]) {
			 model.array_update(rem,1,2);
			 view.cell_update(rem,1,2);
			 view.button_disable(1,2);
		}
		else if(e.getSource() == view.button[2][0]) {
			 model.array_update(rem,2,0);
			 view.cell_update(rem,2,0);
			 view.button_disable(2,0);
		}
		else if(e.getSource() == view.button[2][1]) {
			 model.array_update(rem,2,1);
			 view.cell_update(rem,2,1);
			 view.button_disable(2,1);
		}
		else if(e.getSource() == view.button[2][2]) {
			 model.array_update(rem,2,2);
			 view.cell_update(rem,2,2);
			 view.button_disable(2,2);
		}
		
		int win = model.get_winner();//winner is taken if any
		
		if (win != -1) {//if there is a winner
			val = 0;//val is 0
			model.array_reset();//array is reset
			
			
			int dialogResult;
			if (win != 0) {//not draw
				dialogResult =  view.winner_window(win);
				if(dialogResult == JOptionPane.YES_OPTION)//play agian
				{
					view.setVisible(false);//curent windows are closed
					view.frame.dispose();

					Model model = new Model();
				    View view = new View();
				    new Controller(view,model);
				}
				else//don't play again
				{	
					view.dispatchEvent(new WindowEvent(view.frame, WindowEvent.WINDOW_CLOSING));
					System.exit(0);
				}	
			}
			else {//draw
				dialogResult =  view.draw_window(win);
				if(dialogResult == JOptionPane.YES_OPTION)//wants to play again
				{
					view.setVisible(false);
					view.frame.dispose();
					Model model = new Model();
				    View view = new View();
				    new Controller(view,model);
				}
				else//no need to play again
				{	
					view.dispatchEvent(new WindowEvent(view.frame, WindowEvent.WINDOW_CLOSING));
					System.exit(0);
				}	
			}
		}
	}	
}