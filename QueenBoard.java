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
    int r1 = r;
    int c1 = c;
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
    while(r1<board.length-1&&c1>0){
      r1++;
      c1--;
    }
    //diagonal
    while(r<board.length&&c<board.length){
      if(board[c][r]!=-1){
        board[c][r]+=1;
      }
      c++;
      r++;
    }
    while(r1>0&&c1<board.length){
      System.out.println(r1+" "+c1);
      if(board[c1][r1]!=-1){
        board[c1][r1]+=1;
      }
      c1++;
      r1--;
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
    r = R;
    c = C;
    while(r<board.length-1&&c>0){
      r++;
      c--;
    }
    while(r>0&&c<board.length){
      System.out.println(r+" "+c);
      if(board[c][r]!=-1){
        board[c][r]+=1;
      }
      c--;
      r++;
    }
    board[C][R] = 0;
    return true;
  }

  public boolean solve(){
    return solveH(0,0);
  }

  private boolean solveH(int r, int c){
    if(r>=board.length){
      return true;
    }
    for(int i = 0; i<board.length;i++){
      System.out.println(this.toStringDebug());
      if(addQueen(r,i)){
        return solveH(r+1,0);
      }
      if(i==board.length){
        removeQueen(r,c);
      }
    }
    return false;
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
    /*
    QueenBoard b = new QueenBoard(5);
    System.out.println(b.solve());
    */
  }
}
