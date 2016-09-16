package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;

public class TicTacToeTest {
	private TicTacToe model;
	
	@Before
	public void setup () {
		model = new TicTacToe();
		model.setNewBoard();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				assertEquals(" ", model.getMark(i,j));
			}			
		}		
	}
	
	
	@Test
	public void testMarkUpperRightCorner() {		
		model.makeMark(0,2);
		assertEquals("X",model.getMark(0,2));	
	}
	
	@Test
	public void testMarkBottomLeftCorner() {
		model.makeMark(2,0);
		assertEquals("X",model.getMark(2,0));
	}
	
	@Test
	public void testNoMarkOverExistingMark() {
		model.makeMark(2,0);        
		model.makeMark(2,0);
		assertEquals("X", model.getMark(2,0));
	}
	
	@Test
	public void testGameContinueAfterFirstMark() {
		model.makeMark(2,0);
		assertEquals(" ", model.getWinner());
	}
	
	@Test
	public void testTopRowVictory() {		
		model.makeMark(0,0);
		model.makeMark(1,2);
		model.makeMark(0,1);
		model.makeMark(2,1);
		model.makeMark(0,2);
		assertEquals(model.getWinner(),"X");
	}
	
	
	@Test
	public void testDiagonalVictory(){		
		model.makeMark(0,0);
		model.makeMark(2,1);
		model.makeMark(1,1);
		model.makeMark(0,2);
		model.makeMark(2,2);
		assertEquals(model.getWinner(),"X");
	}
	@Test
	
	public void testLeftVerticalVictory(){		
		model.makeMark(0,0);
		model.makeMark(0,1);
		model.makeMark(1,0);
		model.makeMark(1,1);
		model.makeMark(2,0);
		assertEquals(model.getWinner(),"X");
	}
	
	
	@Test
	public void testGameOverByTie() {		
		model.makeMark(0,0);		
		model.makeMark(0,1);		
		model.makeMark(0,2);		
		model.makeMark(2,0);		
		model.makeMark(2,1);		
		model.makeMark(2,2);		
		model.makeMark(1,0);		
		model.makeMark(1,1);		
		model.makeMark(1,2);
		assertEquals(model.getWinner(), "TIE");
	}
}
