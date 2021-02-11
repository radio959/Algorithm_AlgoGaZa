package com.study15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*1234와 1324의 최소 비용이 다르기 때문에 순열로 풀어볼 것이다.
 * 
 * 
 * 
*/

public class backjoon_10971_외판원순회 {
	static int N; // 전체 정점의 수 
	//static int cnt; //조합을 위한 카운트
	static int map[][]; // 간선들의 연결된 정보를 알고 있는 배열
	static boolean isSelected[];
	static int min=9999999;
	static int start;
	static void dfs(int cnt,int x,int sum ) {
		isSelected[x]=true;
		
		if(cnt==N&&map[x][start]>0) {
			min=Math.min(min, sum+map[x][start]);
			System.out.println(min);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!isSelected[i]&&map[x][i]>0) {
			
			isSelected[i]=true;
			dfs(cnt+1,i,sum+map[x][i]);
			isSelected[i]=false;
			
			}
		}
		isSelected[x]=false;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N을 입력 -> 도시의 수 
		
		map= new int[N+1][N+1];
		isSelected = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," "); 
			for (int j = 1; j <= N; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());//-> 간선의 가중치 추가
		
			}
		}
	
		for (int i = 1; i <= N; i++) {
			start =i;

			dfs(1,i,0);

		}
		System.out.println(min);
	}
}
