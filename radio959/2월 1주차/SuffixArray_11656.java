package week2;

import java.util.Arrays;
import java.util.Scanner;
/*문제 해결 방법
 * 1. String을 입력받고,
 * 2. String 배열에다가 for문 String 길이만큼 돌면서, substring들을 싹다 저장.
 * 3. String 배열을 돌면서 정렬
*/
public class SuffixArray_11656 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 문장 하나 입력 받고
		String[] suffixes = new String[s.length()]; //suffixes배열을 s의 길이만큼 할당
		
		for(int i=0; i<s.length();i++)
			suffixes[i]=s.substring(i); // suffixes 배열에 substring값들을 저장
		
		Arrays.sort(suffixes); // 정렬
		
		for(int i=0; i<s.length(); i++) // 출력
			System.out.println(suffixes[i]);
	}

}
