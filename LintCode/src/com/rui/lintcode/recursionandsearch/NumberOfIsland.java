package com.rui.lintcode.recursionandsearch;

//http://www.lintcode.com/en/problem/number-of-islands/
public class NumberOfIsland {
	public int numIslands(boolean[][] grid) {
        int count=0;
       int m=grid.length;
       if(m<=0) return count;
       
       int n=grid[0].length;
       boolean[][] visited=new boolean[m][n];
 
       
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(!visited[i][j]&&grid[i][j]){
                    count++;
                    search(grid,m,n, i, j, visited);
               }
           }
       }
      return count; 
       
   }
   
   //tranvese 
   private void search(boolean[][] grid,int m,int n, int i,int j, boolean[][] visited){
       if(i>=m||j>=n||i<0||j<0||visited[i][j]||!grid[i][j]) return;
        int[] dx = {1, 0,-1,0};
        int[] dy = {0, 1,0,-1};
        
        for(int k=0;k<4;k++){
            int nexti=i+dx[k];
            int nextj=j+dy[k];
            if(nexti>=0 && nexti<m&&nextj>=0&&nextj<n){
                   visited[i][j]=true;
                   search(grid,m,n,nexti,nextj,visited);
            }
        }  
       
   }

}
