package com.study02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				int N =sc.nextInt();
				int max=0;
				int[] box = new int[N];
				int[] bl = new int[N];
				
				
				for(int i =0 ; i< N; i++)
				{	int size = sc.nextInt();
					box[i]=size;
					bl[i]=1;
				}
				
				for(int i =0 ; i< N; i++)
				{	
					for(int j=0;j<i;j++) {
						if(box[i]>box[j] &&bl[j]+1 > bl[i])
						{
						bl[i]=bl[j]+1;	
						}	
					}
				
				
				}
				for(int i=0;i<N;i++) {
					if(bl[i]>max) {
						max = bl[i];
					}
				}
				System.out.println(max);
			}	

		}
