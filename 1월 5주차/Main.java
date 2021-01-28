package com.study04;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int N = sc.nextInt();
	int cnt = 0;
	int D[] = new int[100001];
	D[1]=1;
	for(int i=2;i<=N;i++) {
		if(i<2) {
			D[i]=D[i-1]+1;
		}
		else if(i<5) {
			D[i] = Math.min(D[i-1],D[i-2])+1;
		}
		else if(i<7) {
			D[i] = Math.min(D[i-5], Math.min(D[i-1],D[i-2]))+1;
		}
		else 
			D[i] = Math.min(D[i-7], (Math.min(D[i-5], Math.min(D[i-1],D[i-2]))))+1;
	}

	System.out.println(D[N]);











	}	
}
