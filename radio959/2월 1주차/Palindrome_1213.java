package week2;

import java.util.Arrays;
import java.util.Scanner;

/* 풀이 방법
 * AABB --> ABBA
 * ABCABABC
 * 1. 알파벳 배열을 선언한다.
 * 2. 입력받으면서 알파벳 배열에다가 사용한 알파벳이 있으면 ++
 * 3. 배열 요소중에 홀수 인게 두 개 이상이면 --> I'm Sorry Hansoo"
 * 4. 두 개 이상이 아니면, A부터 돌면서 처음과 끝에 배치
 * 		4-1. 그 알파벳이 홀수 개라면, 한 개를 가운데(String.length/2)에 짱박고
 * 		4-2. 짝수 개라면, 처음과 끝에 배치
*/
public class Palindrome_1213 {
	static int[] alphabet;
	static int odd; // 홀수인 알파벳을 표시해주기 위한 odd

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		alphabet = new int[26];
		boolean possible = false;

		String s = sc.next();
		char[] c = s.toCharArray(); // String을 char 배열로 바꾸고
		Arrays.sort(c); // 걍 한번 정렬 ㄱㄱ
		for (int i = 0; i < s.length(); i++) {
			alphabet[c[i] - 65]++; // 얼마나 사용됐는지도 입력
		}

		for (int i = 0; i < 26; i++) { // 알파벳 int 배열 돌면서
			if (alphabet[i] % 2 != 0) { // 홀수면
				if (possible == false) {// 처음나온거면 봐주고
					possible = true;
					odd = i; // 언제인지 저장
				} else if (possible == true) {
					System.out.println("I'm Sorry Hansoo"); // 두번 나온거면 암쏘리 핸수
					return; // 하고 리턴
				}
			}
		}

		char[] ans = new char[c.length];
		int a = 0;
		int index_start = 0;
		int index_end = c.length - 1;

		while (true) {
			if (a == c.length)
				break;
			for (int i = 0; i < alphabet[c[a] - 65] / 2; i++) {
				ans[index_start++] = c[a];
			}
			for (int i = 0; i < alphabet[c[a] - 65] / 2; i++) {
				ans[index_end--] = c[a];
			}

			a = a + alphabet[c[a] - 65];
		}
		if(c.length%2!=0) // 홀수인 경우만
			ans[c.length / 2] = (char) (odd + 65); // 가운데에 홀수인 값을 넣어주기

		for (int i = 0; i < ans.length; i++) // 출력
			System.out.print(ans[i]);
	}

}
