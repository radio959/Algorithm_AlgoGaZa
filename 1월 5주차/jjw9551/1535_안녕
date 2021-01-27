package com.study03;

import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] L = new int[N+1];
		int[] J = new int[N+1];
		int[][]D =new int [21][101];
		int max=0;
		for(int i = 1 ; i<=N;i++) {
			L[i]=sc.nextInt();
		}
		
		for(int i = 1 ; i<=N;i++) {
			J[i]=sc.nextInt();
		}
		
		for(int i = 1 ; i<=N;i++) {
			for(int j=1; j<100;j++) {
				if(L[i] <=j && (D[i-1][j-L[i]] + J[i] > D[i][j])) {
					D[i][j] = Math.max(J[i] + D[i-1][j - L[i]], D[i-1][j]);
				}
				else
					D[i][j] = D[i-1][j];
				max = Math.max(D[i][j], max);
			}
			
				
		}

		System.out.println(max);
	}
 }
