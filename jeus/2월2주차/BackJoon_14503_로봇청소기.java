package com.study11;

import java.awt.print.Printable;
import java.util.Scanner;

public class BackJoon_14503_로봇청소기 {
	static int x;
	static int y;
	static int cleanPlace;
	static int clearPlace;
	static int dir;
	static int cnt=0;
	static int cnt2=1;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static int[][]map;
	static boolean[][] isClean;
	static boolean flagL;
	static boolean flagD;
	static boolean flagU;
	static boolean flagR;
	public static void search() {
		while(true) {
		int nx;
		int ny;
		//int cnt=0;
		flagL=false;
		flagD=false;
		flagU=false;
		flagR=false;
		if(!isClean[x][y]) {
		clearPlace++;
		}
		isClean[x][y]=true;
		


		switch(dir) {
		case 0: 
				nx=x +dx[dir];
				ny=y +dy[dir];
				dir=3;
				cnt++;
				if(!isClean[nx][ny]&&map[nx][ny]!=1) {
					x=nx;
					y=ny;
					//clearPlace++;
					map[nx][ny]=++cnt2;
					cnt=0;
					break;
				}
				flagL=true;
				
		
		case 3: 
				nx=x +dx[dir];
				ny=y +dy[dir];
				dir=2;
				cnt++;
				if(!isClean[nx][ny]&&map[nx][ny]!=1) {
					x=nx;
					y=ny;
					map[nx][ny]=++cnt2;
					cnt=0;
					break;
				}
				flagD=true;
		
		case 2: 
				nx=x +dx[dir];
				ny=y +dy[dir];
				dir=1;
				cnt++;
				if(!isClean[nx][ny]&&map[nx][ny]!=1) {
					x=nx;
					y=ny;
					map[nx][ny]=++cnt2;
					cnt=0;
					break;
				}
				flagR=true;
		case 1: 
				nx=x +dx[dir];
				ny=y+dy[dir];
				dir=0;
				cnt++;
				if(!isClean[nx][ny]&&map[nx][ny]!=1) {
					x=nx;
					y=ny;
					cnt=0;
					map[nx][ny]=++cnt2;
					break;
				}
				flagU=true;
			}
		if(cnt>=4) { //후진할경우
			dir=(cnt)%4;
			
			cnt=0;
			if(dir==0&&map[x+1][y]!=1) {x++; continue;} 
			if(dir==1&&map[x][y-1]!=1) {y--; continue;}
			if(dir==2&&map[x-1][y]!=1) {x--; continue;}
			if(dir==3&&map[x][y+1]!=1) {y++; continue;}
			//clearPlace--;
			//break;
			//cnt=0;
			//continue;
		}	
			
			if(flagL&&flagD&&flagU&flagR) {
				if(dir==0&&map[x+1][y]==1)
					break;
				
				if(dir==1&&map[x][y-1]==1)
					break;
				
				if(dir==2&&map[x-1][y]==1)
					break;
				
				if(dir==3&&map[x][y+1]==1)
					break;
				
			}
			
		}
		 
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		map = new int[N][M];
		isClean = new boolean [N][M];
		
		x= sc.nextInt();
		y= sc.nextInt();
		dir = sc.nextInt();
		cleanPlace=0;
		clearPlace=0;
		
		isClean[x][y]=true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0) {
					cleanPlace++;
				}
			}
		}
		search();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+ "  ");
//				}
//			System.out.println();
//			}
//		

		System.out.println(clearPlace+1);
		
		
	}

}
