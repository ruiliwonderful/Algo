package com.rui.lintcode.dp;

import java.util.Arrays;

public class BackPack {

	public int backPack(int m, int[] A) {
		int len = A.length;

		Arrays.sort(A);
		boolean[][] pack = new boolean[m + 1][len + 1];

		for (int i = 0; i <= len; i++) {
			pack[0][i] = true;
		}

		for (int j = 1; j <= m; j++) {
			pack[j][0] = false;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= len; j++) {
				if (i >= A[j - 1]) {
					pack[i][j] = pack[i][j-1] || pack[i-A[j-1]][j - 1];
				} else
					pack[i][j] = pack[i][j-1];
			}
		}
		
		for(int i=0;i<m+1;i++){
			for(int j=0;j<len+1;j++){
				if(pack[i][j]) System.out.print('o');
				else System.out.print('x');
			}
			System.out.println();
		}
		
		

		int result = 0;

		for (int j = m; j > 0; j--) {
			if (pack[j][len]) {
				result = j;
				break;
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		BackPack bp=new BackPack();
		int m=10;
		int[] a={3,4,8,5};
		System.out.println(bp.backPack(m, a));	
	}
	
}
