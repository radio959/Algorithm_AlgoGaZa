package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baseball_17281 {
	static int[] results;
	static boolean[] played;
	static boolean[] jalu;
	static int score;
	static int cnt;
	static int outcount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		results = new int[9];
		played = new boolean[9];
		jalu = new boolean[4];
		cnt=0;
		outcount=0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 9; i++)
			results[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 9; i++) {
			if (i == 3)
				continue;

			playball(i);
		}

		score = 0;
	}

	public static void playball(int i) {
		if(outcount==3) { // 3아웃이면
			outcount=0; // 아웃카운트 초기화
			return;
		}
		if(played[i]) { // 이미 플레이 한 선수면
			playball(i+1); // 다음 선수걸로
		}
		if(cnt+1==4) // 4번 타자라면 
			playball(3); // 4번 타자 수행해야함.
		
		if(results[i]==0) { // 아웃이면
			played[i]=true; // 플레이 했다고 체크
			cnt++; // 타석 ++
			
			outcount++; // 아웃카운트도 ++
			playball(i+1); // 다음타자
			
		}else if(results[i]==1) {
			played[i]=true;
			cnt++;
			if(!jalu[1])
				jalu[1]=true;
			else if(jalu[1]&&!jalu[2])
				jalu[2]=true;
			else if(jalu[1]&&jalu[2]&&!jalu[3])
				jalu[3]=true;
			else if(jalu[1]&&jalu[2]&&jalu[3]) {
				score++;
			}
			
		}else if(results[i]==2) {
			played[i]=true;
			cnt++;
						
		}else if(results[i]==3) {
			played[i]=true;
			cnt++;
			
		}else if(results[i]==4) {
			played[i]=true;
			cnt++;
			
		}

	}

}
