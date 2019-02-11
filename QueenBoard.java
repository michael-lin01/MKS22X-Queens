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
    while(r1>0&&c1<board.length-1){
      r1--;
      c1++;
    }
    //diagonal
    while(r<board.length&&c<board.length){
      if(board[c][r]!=-1){
        board[c][r]+=1;
      }
      c++;
      r++;
    }
    while(r1<board.length&&c1>=0){
      if(board[c1][r1]!=-1){
        board[c1][r1]+=1;
      }
      c1--;
      r1++;
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
    while(r>0&&c<board.length-1){
      r--;
      c++;
    }
    while(r<board.length&&c>=0){
      if(board[c][r]!=-1){
        board[c][r]--;
      }
      c--;
      r++;
    }
    board[C][R] = 0;
    return true;
  }

  public boolean solve(){
    if(board[0][0]!=0) throw new IllegalStateException();
    return solveH(0);
  }

  private boolean solveH(int c){
    if(c>=board.length){
      //System.out.println(this.toString());
      //System.out.println(this.toStringDebug());
      return true;
    }
    for(int r = 0; r<board.length;r++){
      if(addQueen(r,c)){
        if (solveH(c+1)){
          return true;
        }
        removeQueen(r,c);
      }
    }
    //System.out.println(this.toString());
    //System.out.println(this.toStringDebug());
    return false;
  }

  public int countSolutions(){
    if(board[0][0]!=0) throw new IllegalStateException();
    return countH(0);
  }

  private int countH(int c){
    if(c >= board.length){
      //System.out.println(this);
      //System.out.println(this.toStringDebug());
      return 1;
    }
    int count = 0;
    for(int r = 0; r < board.length; r++){
      if(addQueen(r,c)){
        count += countH(c+1);
        removeQueen(r,c);
      }
    }
    //System.out.println(this);
    //System.out.println(this.toStringDebug());
    return count;
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
    /* testing add and remove
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
    b.removeQueen(2,3);
    b.addQueen(3,0);
    System.out.println(b);
    System.out.println(b.toStringDebug());
    b.removeQueen(3,0);
    System.out.println(b);
    System.out.println(b.toStringDebug());
    */

    //System.out.println(b.solve());
    //System.out.println(b);
    QueenBoard b = new QueenBoard(14);
    System.out.println(b.countSolutions());
    System.out.println(b);
    System.out.println(b.solve());
    System.out.println(b);
  }
}
