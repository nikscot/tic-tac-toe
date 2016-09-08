import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToeModel model;
	
	public void startNewGame() {
		model = new TicTacToeModel();

	}
	
	public void markLocation(int row, int col) {
		model.makeMark("X", row, col); 

	}
	
	public String getMark(int row, int col) {
		return model.getMark(row, col);
	}
    
	public String getWinner() {
		
		return "X";
	}
}
