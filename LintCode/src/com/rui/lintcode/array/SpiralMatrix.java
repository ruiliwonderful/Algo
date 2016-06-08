package com.rui.lintcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	/**
	 * http://www.lintcode.com/en/problem/spiral-matrix/
	 * @param matrix
	 *            a matrix of m x n elements
	 * @return an integer list
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();

		int m = matrix.length;
		int n = matrix[0].length;

		int left = 0;
		int right = n - 1;
		int upper = 0;
		int down = m - 1;

		int i = 0;
		int j = 0;

		while (left <= right && upper <= down) {
			// go right
			while (j <= right) {
				result.add(matrix[i][j]);
				 if(j!=right) j++;
			}
			i++;
			upper++;
			
		
			
			// go down
			while (i <=down) {
				result.add(matrix[i][j]);
				if(i!=down) i++;
			}
			j--;
			right--;
			// go left
			while (j >= left) {
				result.add(matrix[i][j]);
				if(j!=left) j--;
			}
			i--;
			down--;
			// go up
			while (i >= upper) {
				result.add(matrix[i][j]);
				 if(i!=upper) i--;
			}
			j++;
			left++;
		}

		return result;

	}
	
	
	public int[][] generateMatrix(int n){
		int[][] result=new int[n][n];
        int i=0;
        int j=0;
        

		int left = 0;
		int right = n - 1;
		int upper = 0;
		int down = n - 1;
		
		int value=1;


		while (left <= right && upper <= down) {
			// go right
			while (j <= right &&left <= right && upper <= down) {
				result[i][j]=value;
				value++;
				if(j!=right) j++;
				else {
					i++;
					upper++;
					break;
				}
			}
			
			
		
			
			// go down
			while (i <=down && left <= right && upper <= down) {

				result[i][j]=value;
				value++;
				if(i!=down) i++;
				else {
					j--;
					right--;
					break;
				}
			
				
			}
			
			// go left
			while (j >= left && left <= right && upper <= down) {
				
				result[i][j]=value;
				value++;
				if(j!=left) j--;
				else {
					i--;
					down--;
					break;
				}	
				
			}
			
			// go up
			while (i >= upper&& left <= right && upper <= down) {

				
				result[i][j]=value;
				value++;
				if(i!=upper) i--;
				else {
					j++;
					left++;
					break;
				}	
				
			
				
			}
		
		}

		return result;

	}

	public static void main(String[] args) {
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		SpiralMatrix sp=new SpiralMatrix();
		//sp.spiralOrder(matrix);
		System.out.println(sp.generateMatrix(3));
	}

}
