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
      //horizontal
      if (board[c][i]!=-1){
        board[c][i]++;
      }
      //vertical
      if(board[i][r]!=-1){
        board[i][r]++;
      }
    }
    //goes to edge of the board for diagonal
    while(r>0&&c>0){
      r--;
      c--;
    }
    //diagonal
    while(r<board.length&&c<board.length){
      if(board[c][r]!=-1){
        board[c][r]+=1;
      }
      c++;
      r++;
    }
    return true;
  }
  private boolean removeQueen(int r, int c){
    if(board[c][r]!=-1){
      return false;
    }
    int C = c;
    int R = r;
    for(int i = 0; i < board.length;i++){
      //horizontal
      if (board[c][i]!=-1){
        board[c][i]--;
      }
      //vertical
      if(board[i][r]!=-1){
        board[i][r]--;
      }
    }
    //goes to edge of the board for diagonal
    while(r>0&&c>0){
      r--;
      c--;
    }
    //diagonal
    while(r<board.length&&c<board.length){
      if(board[c][r]!=-1){
        board[c][r]--;
      }
      c++;
      r++;
    }
    board[C][R] = 0;
    return true;
  }

  public boolean solve(){
    return solveH(0,0,0,0);
  }

  private boolean solveH(int r, int c, int prevR, int prevC){
    if(r>=board.length){
      return false;
    }
    if(r==board.length-1&&addQueen(r,c)){
      return true;
    }
    if(addQueen(r,c)){
      return solveH(r+1,0,prevR,prevC);
    }
    return solveH(r,c+1,prevR,prevC);
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
    b.removeQueen(1,1);
    System.out.println(b);
    System.out.println(b.toStringDebug());
  }
}
