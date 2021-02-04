package com.study09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon_1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//ArrayList<String> arr = new ArrayList<>();
		
		int N = sc.nextInt();
		String[] arr =new String[N];
		for(int i =0;i<N;i++) {
			arr[i]=sc.next();
		
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {//길이가 같은경우
					return s1.compareTo(s2);
				}
				else
					return s1.length()-s2.length(); //길이가 다른경우
				
			}
			
		});
			
			
		
		
		for (int i = 0; i < N-1; i++) {
			if(!arr[i].equals(arr[i+1]))
			System.out.println(arr[i]);
		}
		System.out.println(arr[N-1]);
		
	}
}
