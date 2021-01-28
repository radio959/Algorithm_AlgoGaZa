package algorithm_study;

import java.util.Scanner;

public class Box_1965 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(); // 상자의 개수
		int b=1; // 
		int[] box = new int[a]; // 박스 배열 생성
		int[] ans = new int[a]; // 정답 배열 생성
		for(int i=0; i<a; i++) {
			box[i]=sc.nextInt(); // 상자의 크기를 받음.
			ans[i]=1;
		}
		for(int i=0; i<a; i++) {
			for(int j=0; j<i; j++) {
				if(box[j]<box[j+1]) b++; // j번째가 j+1번째보다 값이 작으면 b++
			}
			ans[i]=b;
			b=1;
		}
		int max=0;
		for(int i=0; i<a;i++)
			if(max<ans[i]) max=ans[i];
		System.out.println(max);

	}

}
