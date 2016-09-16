package edu.jsu.mcis;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	private char [][] board = new char [3][3];
	private char player = 'O';
	
	public  void setNewBoard(){
        for (int row = 0; row < board.length;row++){
            Arrays.fill(board[row], ' ');
		}
	}
	private char setPlayer(){
		if (player == 'O'){
			player = 'X';
		}
		else 
			player = 'O';
		return player;
	}
	
	public void makeMark(int row, int column){
		if (row >= 0 && row <= 2 && column >= 0 && column <= 2){
			if (board[row][column] == ' '){
				setPlayer();
				board[row][column] = player;
			}
		}
	}
	
	public String getMark(int row, int column){
		String move = String.valueOf(board[row][column]);
        return move;
	}
	
	private String checkForHorizontalWin(){
		for (int i = 0; i < board.length; i++){
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){
				return Character.toString(board[i][0]);
			}
		}
		return " ";
	}
	
	private String checkForVerticalWin(){
		for (int i = 0; i < board.length; i++){
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != ' '){
				return Character.toString(board[0][i]);
			}
		}
		return " ";
	}
	
	private String checkForDiagonalWin(){
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0]!= ' '){
			return Character.toString(board[0][0]);
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '){
			return Character.toString(board[0][2]);
		}
		return " ";
	}
	
	private boolean checkForTie(){
		int count = 0;
		for (int row = 0; row < board.length;row++){
			if (board[row][0]!= ' ' && board[row][1] != ' ' && board[row][2] != ' '){
				count++;
				if(count == 3){
					return true;
				}
			}
		}
		return false;
	}
	
	public String getWinner(){
		String hWinner = checkForHorizontalWin();
		String vWinner = checkForVerticalWin();
		String dWinner = checkForDiagonalWin();
		if(!hWinner.equals(" ")) return hWinner;
		else if(!vWinner.equals(" ")) return vWinner;
		else if(!dWinner.equals(" ")) return dWinner;
		else if(checkForTie()) return "TIE";
		else return " ";
	}
}
