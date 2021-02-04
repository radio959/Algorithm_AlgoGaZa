package com.study10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Backjoon_1213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		List<Character> result = new ArrayList<>();
		int[] alphabet = new int[26];
		
		for(int i = 'A';i<='Z';i++) {
			for(int j=0;j<N.length();j++) {
				if(N.charAt(j)==i) {
					
				alphabet[i-'A']+=1;
				}
			}
		}
		int mid = 0;
		int cnt = 0;
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i]%2!=0) {
				mid = i;
				cnt++;
			}
		}
		if((cnt>1&&N.length()%2!=0)||cnt>0&&N.length()%2==0) {
			System.out.println("I'm Sorry Hansoo");
			
		}
		else {
//		for(int k: alphabet)
//		System.out.println(k);
		for(int i =0; i <26;i++) {
			for(int j=0; j<alphabet[i]/2; j++) {
				result.add((char) ('A'+i));
			}
			
		}
		if(cnt==1) {
			result.add((char) (mid+'A'));
		}
		boolean flag =true;
		for(int i=result.size();i>0;i--) {
			if(flag&&cnt==1) {
				i--;
				flag=false;
			}
			result.add(result.get(i-1));
		}
		//if(cnt=0) {
		for(char A:result)
		System.out.print(A);
	//}
		}	
}
	}
