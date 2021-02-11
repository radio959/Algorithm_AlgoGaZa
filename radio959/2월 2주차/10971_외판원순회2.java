package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TSP_10971 {
	static int[][] W;
	static boolean[] visit;
	static int N;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = new int[N + 1][N + 1]; // 편의를 위해 N+1로 생성
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(W[i][j]+" ");
//			}System.out.println();
//		}
		
		
		
		int min = 999999999;
		int a;
		ans = 0;
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			tsp(i);
			if (min > W[0][i])
				min = W[0][i];
			Arrays.fill(visit, false);
		}
		System.out.println(min);
	}

	public static void tsp(int a) {
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(visit[i]==true) {
				cnt++;
				if(cnt==N)
					return;
			}
			
		}

		for (int i = 1; i <= N; i++) {
			if (a == i) {
				continue;
			} else if (W[a][i] == 0) {
				continue;
			} else {
				if (!visit[i]) {
					a = W[a][i];
					visit[i] = true;
				}
				tsp(i);
			}
			W[0][i] = a;
		}

		return;
	}

}
