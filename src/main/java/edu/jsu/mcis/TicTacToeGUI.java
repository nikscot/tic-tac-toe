package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame implements ActionListener {
    public TicTacToe model;
	private JButton[][] button;
	
	public TicTacToeGUI(){
		model = new TicTacToe();
		model.setNewBoard();
		button = new JButton[3][3];
		setLayout(new GridLayout(3,3));
		for(int i=0;i<button.length;i++){
			for(int j=0;j<button.length;j++){
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension(100,100));
				button[i][j].addActionListener(this);
				button[i][j].setName("Location"+i+""+j);
				add(button[i][j]);
			}
		}
		
	}
	
	public void checkForWin(){
		String winner = model.getWinner();
		if(winner.equals("X") || winner.equals("O")) { 
			JOptionPane.showMessageDialog(null, "The winner is " + winner, "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (winner.equals("TIE")){
			JOptionPane.showMessageDialog(null, winner, "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void actionPerformed(ActionEvent event){
		JButton b = (JButton)event.getSource();
		String loc = b.getName().substring(8);
		int r = Integer.parseInt(loc.substring(0,1));
		int c = Integer.parseInt(loc.substring(1,2));
		model.makeMark(r,c);
		String s = model.getMark(r, c);
		b.setText(model.getMark(r,c));
		checkForWin();
	}
	
	public static void main (String[] args){
		JFrame win = new JFrame("Tic Tac Toe");
		win.add(new TicTacToeGUI());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
	}
}