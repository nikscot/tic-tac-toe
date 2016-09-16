import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToeGUI m;
	
	public void startNewGame() {
		m = new TicTacToeGUI();

	}
	
	public void markLocation(int row, int col) {
		m.makeMark(row, col); 

	}
	
	public String getMark(int row, int col) {
		return m.getMark(row, col);
	}
    
	public String getWinner() {
		
		return m.getWinner();
	}
}
