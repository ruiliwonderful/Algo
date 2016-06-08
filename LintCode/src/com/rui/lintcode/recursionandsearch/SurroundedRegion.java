package com.rui.lintcode.recursionandsearch;

//http://www.lintcode.com/en/problem/surrounded-regions/
public class SurroundedRegion {
	
	public void surroundedRegions(char[][] board) {
		int m=board.length;
		int n=board[0].length;
        //find  spots on boundary 
		int p=0;
		//int q=0
		int[] x=new int[2*(m+n)];
		int[] y=new int[2*(m+n)];
		
		
		for(int i=0;i<m;i++){
			if(board[i][0]=='0'){
				x[p]=i;
				y[p]=0;
				p++;
			}
			if(board[i][n-1]=='0'){
				x[p]=i;
				y[p]=n-1;
				p++;
			}
			
		}
		
		for(int j=1;j<n;j++){
			if(board[m-1][j]=='0'){
				x[p]=m-1;
				y[p]=j;
				p++;
			}
			if(board[0][j]=='0'){
				x[p]=0;
				y[p]=j;
				p++;
			}
		}
		
		boolean visited[][]=new boolean[m][n];
		boolean nochange[][]=new boolean[m][n];
						
		for(int i=0;i<p;i++){
			if(!visited[x[p]][y[p]])
				updateBoard(board,m,n,x[i],y[i],visited,nochange);
		}
		
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(!nochange[i][j]){
					board[i][j]='X';
				}
			}
		}
			
	}
	
	private void updateBoard(char[][] board, int m, int n, int i,  int j, boolean[][] visited, boolean[][] nochange ){
		if(i<0||i>=m||j<0||j>=n||visited[i][j]||board[i][j]=='X') return;
		int[] dx={1,0,-1,0};
		int[] dy={0,1,0,-1};
		
		visited[i][j]=true;
		nochange[i][j]=true;
		
		for(int k=0;k<4;k++){
			updateBoard(board,m,n,i+dx[k],j+dy[k],visited,nochange);
		}	
		
	}
	
	public static void main(String args[]){
		SurroundedRegion sg=new SurroundedRegion();
		//char[][] board={{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','0'},{'X','0','X','X'}};
		char[][] board={{'0','0'},{'0','X'}};
		sg.surroundedRegions(board);
		for(char[] row:board){
			System.out.println(String.valueOf(row));
		}
	}

}
