public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for(int c = 0; c < board.length;c++){
      for(int r = 0; r < board[c].length;r++){
        board[c][r] = 0;
      }
    }
  }
  private boolean addQueen(int r, int c){
    board[c][r] = -1;
    return true;
  }
  private boolean removeQueen(int r, int c){
    board[c][r] = 0;
    return true;
  }

  public String toString(){
    String ans = "";
    for(int c = 0; c < board.length;c++){
      for(int r = 0; r < board[c].length;r++){
        if(board[c][r]==-1){
          ans+="Q ";
        }
        else{
          ans+= "_ ";
        }
      }
      ans = ans.substring(0,ans.length()-1) + "\n";
    }
    return ans;
  }

  public static void main(String args[]){
    QueenBoard b = new QueenBoard(4);
    System.out.println(b);
    b.addQueen(2,3);
    b.addQueen(1,1);
    b.addQueen(0,0);
    System.out.println(b);
  }
}
