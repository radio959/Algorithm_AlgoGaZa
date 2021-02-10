package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503_풀이 {

	static boolean[][] cleaned;
	static int[][] Map;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		cleaned = new boolean[N][M];

		// r, c, d를 받아옴.
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// map 배열을 채워 넣음.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if(Map[i][j]==1)
					cleaned[i][j]=true;
			}
		}

		cnt=0;
		clean(r, c, d);

		
		System.out.println(cnt);
		/*
		 * 1. 현재 위치를 청소한다. 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다. a) 왼쪽 방향에 아직
		 * 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다. b) 왼쪽 방향에 청소할 공간이 없다면,
		 * 그 방향으로 회전하고 2번으로 돌아간다. c) 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸
		 * 후진을 하고 2번으로 돌아간다. d) 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는
		 * 작동을 멈춘다.
		 */
	}

	public static void clean(int r, int c, int d) {
		
		// 1. 현재 위치를 청소한다.
				if (!cleaned[r][c]) {
					cleaned[r][c] = true;
					cnt++;
				}

		// c) 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
		if (cleaned[r][c - 1] && cleaned[r - 1][c] && cleaned[r][c + 1] && cleaned[r + 1][c]) {
			// d) 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			if (d == 0) { // 북
				if (Map[r + 1][c] == 1)
					return;
				clean(r + 1, c, 0);
			} else if (d == 1) { // 동
				if (Map[r][c - 1] == 1)
					return;
				clean(r, c - 1, 0);
			} else if (d == 2) { // 남
				if (Map[r - 1][c] == 1)
					return;
				clean(r - 1, c, 0);
			} else if (d == 3) { // 서
				if (Map[r][c + 1] == 1)
					return;
				clean(r, c + 1, 0);
			}
			return;
		}

		// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		// a) 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		if (d == 0) { // 북
			// b) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if (Map[r][c - 1] == 1 || cleaned[r][c - 1])
				clean(r, c, 3);

			clean(r, c - 1, 3);

		} else if (d == 1) { // 동
			// b) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if (Map[r - 1][c] == 1 || cleaned[r - 1][c])
				clean(r, c, 0);

			clean(r - 1, c, 0);

		} else if (d == 2) { // 남
			// b) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if (Map[r][c + 1] == 1 || cleaned[r][c + 1])
				clean(r, c, 1);

			clean(r, c + 1, 1);

		} else if (d == 3) { // 서
			// b) 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if (Map[r + 1][c] == 1 || cleaned[r + 1][c])
				clean(r, c, 2);

			clean(r + 1, c, 2);

		}
		return;
	}

}
