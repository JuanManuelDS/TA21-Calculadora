package TA21.Calculadora;

import java.awt.Font;

import javax.swing.JButton;

public class Botones {
	
	public JButton[] getButtons() {
		JButton[] buttons = new JButton[16];
		int numerosBotones = 1;
		for(int i = 0; i<11; i++) {
			if(i!=3 && i!=7) {
				buttons[i] = new JButton(numerosBotones + "");
				numerosBotones++;
			}
		}
		
		buttons[3] = new JButton("+");
		
		buttons[7] = new JButton("-");
		
		buttons[11] =  new JButton("*");
		buttons[12] =  new JButton("0");
		buttons[13] =  new JButton(".");
		buttons[14] =  new JButton("=");
		buttons[15] =  new JButton("/");
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setFont(new Font("Tahoma", Font.BOLD, 32));
		}
		
		return buttons;
	}
	
}
