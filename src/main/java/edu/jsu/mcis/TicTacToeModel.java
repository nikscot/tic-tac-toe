package edu.jsu.mcis;

public class TicTacToeModel {
    public enum Mark {
        EMPTY, 
        XMARK, 
        OMARK;
        public String representation() {
            String n = name().substring(0, 1);
            if("E".equals(n)) return "";
            else return n;
        }
    };
    public enum Result {
        XWIN("X"), 
        OWIN("O"), 
        TIE("TIE"), 
        NONE("NONE");
        private String message;
        private Result(String s) { message = s; }
        public String message() {
            return message;
        }
    };
    private Mark[][] grid;
    private boolean xTurn;
    
    public TicTacToeModel() {
        grid = new Mark[3][3];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }
        xTurn = true;
    }
    
    public boolean setMarkAt(int row, int col) {
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) {
            if(grid[row][col] == Mark.EMPTY) {
                grid[row][col] = (xTurn)? Mark.XMARK : Mark.OMARK;
                xTurn = !xTurn;
                return true;
            }
            else return false;
        }
        else return false;
    }
    
    public Mark getMarkAt(int row, int col) {
        return grid[row][col];
    }
    
    public boolean isXTurn() { return xTurn; }
    public boolean isOTurn() { return !xTurn; }
    
    private Result getHorizontalResult(int row) {
        if(grid[row][0] == grid[row][1] && 
           grid[row][1] == grid[row][2] && 
           grid[row][0] != Mark.EMPTY) {
            if(grid[row][0] == Mark.XMARK) return Result.XWIN;
            else return Result.OWIN;
        }
        else return Result.NONE;
    }
    
    private Result getVerticalResult(int col) {
        if(grid[0][col] == grid[1][col] && 
           grid[1][col] == grid[2][col] && 
           grid[0][col] != Mark.EMPTY) {
            if(grid[0][col] == Mark.XMARK) return Result.XWIN;
            else return Result.OWIN;
        }
        else return Result.NONE;        
    }
    
    private boolean allSpacesFilled() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == Mark.EMPTY) return false;
            }
        }
        return true;
    }
    
    public Result getResult() {
        Result result;
        for(int row = 0; row < grid.length; row++) {
            result = getHorizontalResult(row);
            if(result != Result.NONE) return result;
        }
        for(int col = 0; col < grid[0].length; col++) {
            result = getVerticalResult(col);
            if(result != Result.NONE) return result;
        }
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != Mark.EMPTY) {
            if(grid[0][0] == Mark.XMARK) return Result.XWIN;
            else return Result.OWIN;
        }
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != Mark.EMPTY) {
            if(grid[0][2] == Mark.XMARK) return Result.XWIN;
            else return Result.OWIN;
        }
        if(allSpacesFilled()) return Result.TIE;
        else return Result.NONE;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[i][j] == Mark.EMPTY) sb.append(" ");
                else if(grid[i][j] == Mark.XMARK) sb.append("X");
                else sb.append("O");
                if(j < 2) sb.append("|");
            }
            if(i < 2) sb.append("\n-----\n");
        }
        return sb.toString();
    }
}






