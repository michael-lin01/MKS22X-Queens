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
    if(board[c][r]!=0){
      return false;
    }
    board[c][r] = -1;
    for(int i = 0; i < board.length;i++){
      if (board[c][i]!=-1){
        board[c][i]+=1;
      }
      if(board[i][r]!=-1){
        board[i][r]+=1;
      }
    }
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

  public String toStringDebug(){
    String ans = "";
    for(int c = 0; c < board.length;c++){
      for(int r = 0; r < board[c].length;r++){
        ans+=board[c][r] + " ";
      }
      ans = ans.substring(0,ans.length()-1) + "\n";
    }
    return ans;
  }

  public static void main(String args[]){
    QueenBoard b = new QueenBoard(4);
    System.out.println(b);
    System.out.println(b.toStringDebug());
    b.addQueen(2,3);
    System.out.println(b.toStringDebug());
    b.addQueen(1,1);
    b.addQueen(1,2);
    System.out.println(b.toStringDebug());
    b.addQueen(0,0);
    System.out.println(b);
    System.out.println(b.toStringDebug());
  }
}
