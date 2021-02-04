package com.study10;

import java.util.Scanner;

public class Backjoon_1316_Group {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=0;
		boolean flag;
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			flag=true;
			for (int j = 0; j <s.length(); j++) {
				for (int k = 'a'; k <='z'; k++) {
					if(s.charAt(j)==k) {
						while(s.charAt(j)!=k) {
							j++;
						}
						
					for (int z = j; z <s.length();z++) {
						{if(s.charAt(z)==k);
						flag =false;
						break;}
						}
					}
				}
			if(flag) cnt++;}
			
		}
	System.out.println(cnt);
	}
	
}
