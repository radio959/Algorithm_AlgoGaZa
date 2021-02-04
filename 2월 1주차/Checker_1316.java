package week2;

import java.util.Scanner;

public class Checker_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a;
		boolean[] ans; // 그룹단어인지 아닌지만 알면 됨. boolean
		int count=0; // 그룹단어 일 때 카운트 쁠쁠
		
		int N=sc.nextInt(); // 숫자 입력 받고
		ans = new boolean[N]; // 입력 받을 단어 갯수만큼의 boolean 생성
		
		for(int i=0; i<N; i++) {
			ans[i] = true; //우선 중복문자열이라고 가정
			a=sc.next(); // N번만큼 String a 입력 받기
			
			// 입력받은 문자열은 splitStr에 한 글자씩 저장 되어있음.
			String[] splitStr = a.split("");
			//문자열 길이 만큼 for 돌면서
			for(int j=0; j<a.length(); j++) {
				//splitStr을 0부터 한글자씩 읽으면서 
				//문자가 바뀌었을 때, j번째 전에 중복된 문자가 있는지
				
				//먼저 j가 0보다 크면서 j와 j-1번째 문자열이 다를 때,
				if(j>0 && splitStr[j].compareTo(splitStr[j-1])!=0) {
					for(int k=0; k<j; k++) {
						//0번째부터 j까지 돌면서 j번째 문자와 같은게 있다면
						if(splitStr[k].equals(splitStr[j])) {
							ans[i]=false; // 해당 문자열은 그룹 단어가 아님.
							break; // 더 볼 필요 없음.
						}
					}
				}
				
			}
		}
		for(int i=0; i<N; i++)
			if(ans[i]==true)
				count++;
		
		System.out.println(count);
	}
}
