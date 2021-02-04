package com.study06;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Backjoon_11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pattern = sc.next();
		List<String> subpattern = new ArrayList();
		 ArrayList<String> pitches = new ArrayList<String>();
		//int 
		for(int j = 'a';j<='z';j++) {
		for(int i = 0;i< pattern.length(); i++) {
			if(pattern.charAt(i)== j) {
				subpattern.add(pattern.substring(i));
			}}}
//				if(i+1< pattern.length()&&pattern.charAt(i+1) == j) 
//				{
//					
//				for(int k=1;k<subPattern.length();k++) {
//					if(pattern.charAt(i+k) !=j) {
//						if(pattern.charAt(i+k) > j) {
//							System.out.println(pattern.substring(i));
//						}
//					}
//				}
//				
//			}else
//				System.out.println(subPattern);
				
		Collections.sort(subpattern);
		for(String z : subpattern) {
			if(z!=null)
			System.out.println(z);
		}
}
}
